package com.yuansong.study.server.controller.req;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("MQTT消息发送请求类")
public class MqttSendReq implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2350621249319850617L;
	
	@ApiModelProperty("topic,消息主题")
	private String topic;
	
	@ApiModelProperty("消息实体")
	private String msg;
	
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
