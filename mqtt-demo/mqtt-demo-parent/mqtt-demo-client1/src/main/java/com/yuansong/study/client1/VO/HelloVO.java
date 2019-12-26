package com.yuansong.study.client1.VO;

import java.io.Serializable;

public class HelloVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4222334693587758019L;
	
	private Long id;
	private String msg;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

}
