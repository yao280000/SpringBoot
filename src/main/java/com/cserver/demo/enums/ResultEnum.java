package com.cserver.demo.enums;

public enum ResultEnum {
	UNKNOW_INFO(-1,"未知错误"),
	UNKNOW_MSG(1000,"好错误");
	private ResultEnum(Integer codes, String msg) {
		this.codes = codes;
		this.msg = msg;
	}

	private Integer codes;
	
	private String msg;

	public Integer getCodes() {
		return codes;
	}

	public String getMsg() {
		return msg;
	}
	
	
}
