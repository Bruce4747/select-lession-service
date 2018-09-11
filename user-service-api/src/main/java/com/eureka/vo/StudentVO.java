package com.eureka.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentVO extends UserVO{

	private String studentId;

	private String schoolClass;

	public StudentVO() {
		super();
	}

	public StudentVO(String userName, String userPassword, String userSex, String userPhone, int userAge, String studentId, String schoolClass) {
		super(userName, userPassword, userSex, userPhone, userAge);
		this.studentId = studentId;
		this.schoolClass = schoolClass;
	}

	public StudentVO(String userName, String userPassword, String userPhone, String studentId, String schoolClass) {
		super(userName, userPassword, userPhone);
		this.studentId = studentId;
		this.schoolClass = schoolClass;
	}

	@Override
	public String toString() {
		return "StudentVO{" +
				"studentId='" + studentId + '\'' +
				", schoolClass='" + schoolClass + '\'' +
				super.toString() +
				'}';
	}
}
