package com.meishifeng.demo.utils;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * <ul>
 * <li>ajax请求返回结果实体类</li>
 * <li>User:meishifeng Date:2017/1/5 Time:16:09</li>
 * </ul>
 */
@Getter
@Setter
public class Result {

	private String code;				//响应码
	private String msg;					//响应消息
	private Map<String, Object> data;	//回传内容

	public Result(String code, String msg, Map<String, Object> data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
	public Result(){}

}
