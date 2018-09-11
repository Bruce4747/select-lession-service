package com.eureka.vo;

import lombok.*;

@Getter
@Setter
public class TeacherVO extends UserVO{

	private String teacherId;

	private String researchArea;

	public TeacherVO() {
		super();
	}

	public TeacherVO(@NonNull String teacherId, @NonNull String teacherName, @NonNull String userPassword, @NonNull String userPhone, @NonNull String researchArea) {
		super(teacherName,userPassword,userPhone);
		this.teacherId = teacherId;
		this.researchArea = researchArea;
	}

	public TeacherVO(String teacherId, String teacherName, String userPassword, String userPhone, String researchArea, String userSex, int userAge) {
		super(teacherName,userPassword,userPhone,userPhone,userAge);
		this.teacherId = teacherId;
		this.researchArea = researchArea;
	}

	@Override
	public String toString() {
		return "TeacherVO{" +
				"teacherId='" + teacherId + '\'' +
				", researchArea='" + researchArea + '\'' +
				super.toString() +
				'}';
	}
}
