package com.eureka.vo;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
public class UserVO {

	private String userName;

	private String userPassword;

	private String userSex;

	private String userPhone;

	private int userAge;

	private Date createTime;

	public UserVO() {}

	public UserVO(@NonNull String userName, @NonNull String userPassword, String userSex, String userPhone, int userAge) {
		this.userName = userName;
		this.userPassword = userPassword;
		this.userSex = userSex;
		this.userPhone = userPhone;
		this.userAge = userAge;
	}

	public UserVO(@NonNull String userName, @NonNull String userPassword, @NonNull String userPhone) {
		this.userName = userName;
		this.userPassword = userPassword;
		this.userPhone = userPhone;
	}

	@Override
	public String toString() {
		return ", userName='" + userName + '\'' +
				", userPassword='" + userPassword + '\'' +
				", userSex='" + userSex + '\'' +
				", userPhone='" + userPhone + '\'' +
				", userAge=" + userAge +
				", createTime=" + createTime;
	}
}
