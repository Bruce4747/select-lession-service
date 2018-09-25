package com.eureka.service;

import com.eureka.service.Interface.UserManagerApi;
import com.eureka.dto.Response;
import com.eureka.dao.UserDAO;
import com.eureka.util.CommonUtil;
import com.eureka.vo.StudentVO;
import com.eureka.vo.TeacherVO;
import com.eureka.vo.UserVO;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
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
	public Response registerTeacher(String schoolID, String teacherName, String userPassword, String userPhone,String researchArea) {
		try{
			String teacherId = CommonUtil.generateTeacherId(schoolID);
			String md5Password = CommonUtil.md5Str(userPassword);
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
	 * 可能抛出空指针异常，数据库更新错误
	 * 空指针 来自StudentVO参数lombok非空检测
	 * 更新失败 可能为主键#{name}冲突
	 * @return 如成功，code = 200、desc = 新建教师用户成功、result = TeacherVO
	 */
	@Override
	public Response registerStudent(String schoolID, String studentName, String userPassword, String userPhone, String schoolClass) {
		try{
			String studentId = CommonUtil.generateTeacherId(schoolID);
			String md5Password = CommonUtil.md5Str(userPassword);
			StudentVO studentVO = new StudentVO(studentName,md5Password,userPhone,studentId,schoolClass);
			int count = userDAO.registerNewStudent(studentVO);
			if (count > 0){
				return new Response<>("新建学生用户成功", studentVO);
			}
		}catch (NullPointerException e){
			return Response.SYS_NULL_POINT;
		}

		return Response.DATABASES_ERR_FAILED;
	}


	/**
	 * 登陆 学生/教师
	 * 可能出现，用户名或密码不正确，未知的/未定义的登陆代码
	 * 用户名或密码不正确 id错误找不到，登陆编码错误，密码错误
	 * 未知的/未定义的登陆代码
	 * @return
	 */
	@Override
	public Response login(@NonNull String userLevel, String id, @NonNull String userPassword) {
		UserVO userVO;
		if (STUDENT_LOGIN_CODE.equals(userLevel))
			userVO = userDAO.searchStudentInfo(id);

		else if (TEACHER_LOGIN_CODE.equals(userLevel))
			userVO = userDAO.searchTeacherInfo(id);

		else
			return Response.SYS_UNOPENED_IDENTIFY;

		if (Objects.isNull(userVO)){
			return Response.USER_ID_PASSWORD;
		}
		String md5Password = CommonUtil.md5Str(userPassword);
		if (userVO.getUserPassword().equals(md5Password)){
			String uuid = UUID.randomUUID().toString();
			return new Response("登陆成功", uuid);
		}
		return Response.USER_ID_PASSWORD;
	}

}
