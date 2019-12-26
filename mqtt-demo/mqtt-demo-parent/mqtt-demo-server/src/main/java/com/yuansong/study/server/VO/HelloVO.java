package com.yuansong.study.server.VO;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("字典表视图传输类")
public class HelloVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1653255119324944983L;
	
	@ApiModelProperty("id")
	private Long id;
	
	@ApiModelProperty("消息")
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
