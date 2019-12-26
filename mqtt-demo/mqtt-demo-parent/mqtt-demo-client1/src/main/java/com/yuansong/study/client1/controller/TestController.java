package com.yuansong.study.client1.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yuansong.study.client1.controller.req.MqttReceiveTopicAdd;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "02功能测试")
@RestController
@RequestMapping("/test")
public class TestController {
	
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	private MqttPahoMessageDrivenChannelAdapter mqttPahoMessageDrivenChannelAdapter;

	@ApiOperation("添加监听")
	@PostMapping("/topicAdd")
	public String topicAdd(@RequestBody MqttReceiveTopicAdd req) {
		logger.debug("添加监听: " + req.getTopic());
		this.mqttPahoMessageDrivenChannelAdapter.addTopic(req.getTopic());			
		return "OK";
	}
	
	@ApiOperation("取消监听")
	@PostMapping("/topicDel")
	public String topicDel(@RequestBody MqttReceiveTopicAdd req) {
		logger.debug("取消监听: " + req.getTopic());
		this.mqttPahoMessageDrivenChannelAdapter.removeTopic(req.getTopic());
		return "OK";
	}
	
	@ApiOperation("获取监听主题列表")
	@GetMapping("/topicList")
	public List<String> topicList() {
		logger.debug("获取监听主题列表");
		String[] l = this.mqttPahoMessageDrivenChannelAdapter.getTopic();
		ArrayList<String> result = new ArrayList<String>();
		for (String str : l) {
			result.add(str);
		}
		return result;
	}
	
//	private boolean isTopicListening(String topic) {
//		for (String str : this.mqttPahoMessageDrivenChannelAdapter.getTopic()) {
//			if (topic.equals(str)) {
//				return true;
//			}
//		}
//		return false;
//	}
}
