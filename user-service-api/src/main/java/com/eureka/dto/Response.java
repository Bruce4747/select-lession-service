package com.eureka.dto;

import com.eureka.vo.CacheVO;
import lombok.Data;

@Data
public class Response<T> {

	//系统统一返回值
	private int code;

	//系统统一描述信息
	private String desc;

	//系统统一返回信息 泛型
	private T result;

	/**
	 * 100 - 系统运行期异常
	 * 9000 未知错误
	 * 9001 运行期异常
	 */
	public static final Response<String> SYS_ERR_DESC = new Response<>(1009000, "未知错误");
	public static final Response<String> SYS_NULL_POINT = new Response<>(1009001, "空指针异常");
	public static final Response<String> SYS_UNOPENED_IDENTIFY = new Response<>(1009002, "未开放/无权访问");

	public Response(RuntimeException e){
		this.code = 1009001;
		this.desc = "运行期异常";
		this.result = (T) e.getMessage();
	}

	/**
	 * 200 - 数据库异常
	 */
	public static final Response<String> DATABASES_ERR_DESC = new Response<>(2009000,"数据库未知错误");
	public static final Response<String> DATABASES_ERR_TIMEOUT = new Response<>(2009001,"数据库连接超时");
	public static final Response<String> DATABASES_ERR_FAILED = new Response<>(2009002,"数据库更新失败");
	public static final Response<String> DATABASES_LOW_STOCKS = new Response<>(2009002,"余量不足");

	/**
	 * 280 - 微服务相关异常
	 */
	public static final Response<String> MICRO_SERVICE_UNUSE = new Response<>(2809000, "当前微服务不可用");

	public Response(int code, String desc){
		this.code = code;
		this.desc = desc;
	}

	/**
	 * 300 - 网络连接异常
	 */
	public static final Response<String> HTTP_CONNECTION_TIME = new Response<>(3009000,"网络连接超时");

	/**
	 * 400 - 权限相关
	 */
	public Response(CacheVO cacheVO) {
		this.code = 9102;
		this.desc = cacheVO.getChannelId();
		this.desc = "访问权限为:" + cacheVO.getLevel();
	}
	/**
	 * 500 - 用户相关异常
	 */
	public static final Response<String> USER_ID_PASSWORD = new Response<>(5009000, "[用户名]/[密码]不正确");

	public Response() {}

	//标准构造函数
	public Response(int code, String desc, T result) {
		this.code = code;
		this.desc = desc;
		this.result = result;
	}

	//成功
	public Response(String desc, T result) {
		this.code = 200;
		this.desc = desc;
		this.result = result;
	}
}
