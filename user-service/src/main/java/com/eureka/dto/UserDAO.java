package com.eureka.dto;

import com.eureka.vo.StudentVO;
import com.eureka.vo.TeacherVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserDAO {

	int registerNewTeacher(TeacherVO teacherVO);

	int registerNewStudent(StudentVO teacherVO);

	TeacherVO searchTeacherInfo(String teacherId);

	StudentVO searchStudentInfo(String studentId);
}
