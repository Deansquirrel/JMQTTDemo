package com.yuansong.study.client1.controller.req;

import java.io.Serializable;

public class MqttReceiveTopicAdd implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6383899308673976665L;
	
	private String topic;

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

}
