package com.eureka.service;

import com.eureka.OpenApi.UserManagerApi;
import com.eureka.dto.Response;
import com.eureka.dto.UserDAO;
import com.eureka.util.CommonUtil;
import com.eureka.vo.TeacherVO;
import com.eureka.vo.UserVO;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static com.eureka.util.CommonValue.*;

@Service
public class UserManagerService implements UserManagerApi {

	@Autowired
	private UserDAO userDAO;

	/**
	 * 注册教师用户
	 * 可能抛出空指针异常，数据库更新错误
	 * 空指针 来自TeacherVO参数lombok非空检测
	 * 更新失败 可能为主键#{name}冲突
	 * @return 如成功，code = 200、desc = 新建教师用户成功、result = TeacherVO
	 */
	@Override
	public Response register(String schoolID, String teacherName, String userPassword, String userPhone,String researchArea) {
		String teacherId = CommonUtil.generateTeacherId(schoolID);
		String md5Password = CommonUtil.md5Str(userPassword);
		try{
			TeacherVO teacherVO = new TeacherVO(teacherId,teacherName,md5Password,userPhone,researchArea);
			int count = userDAO.registerNewTeacher(teacherVO);
			if (count > 0){
				return new Response<>("新建教师用户成功", teacherVO);
			}
		}catch (NullPointerException e){
			return Response.SYS_NULL_POINT;
		}

 		return Response.DATABASES_ERR_FAILED;
	}

	/**
	 * 注册学生用户
	 * @return
	 */

	@Override
	public Response login(@NonNull String userLevel, String id, @NonNull String userPassword) {
		UserVO userVO;
		if (STUDENT_LOGIN_CODE.equals(userLevel))
			userVO = userDAO.searchStudentInfo(id);

		else if (TEACHER_LOGIN_CODE.equals(userLevel))
			userVO = userDAO.searchTeacherInfo(userLevel);

		else
			return Response.SYS_UNOPENED_IDENTIFY;

		String md5Password = CommonUtil.md5Str(userPassword);
		if (userVO.getUserPassword().equals(md5Password)){
			String uuid = UUID.randomUUID().toString();
			return new Response("登陆成功", uuid);
		}
		return Response.USER_ID_PASSWORD;
	}

}
