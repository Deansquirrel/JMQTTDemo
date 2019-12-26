package com.yuansong.study.server.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.yuansong.study.server.controller.req.MqttSendReq;
import com.yuansong.study.server.service.MqttGateway;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/test")
@Api(tags="02功能测试")
public class TestController {
	
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	private MqttGateway mqttGateway;
	
	@ApiOperation("发送测试消息")
	@PostMapping("/mqttSend")
	public String mqttSend(@RequestBody MqttSendReq req) {
		Gson gson = new Gson();
		logger.debug(gson.toJson(req));
		try {
			this.mqttGateway.sendToMqtt(req.getMsg(), req.getTopic());
		} catch (Exception e) {
			logger.debug(e.getMessage());
			return "error";
		}
		return "OK";
	}
	
}
