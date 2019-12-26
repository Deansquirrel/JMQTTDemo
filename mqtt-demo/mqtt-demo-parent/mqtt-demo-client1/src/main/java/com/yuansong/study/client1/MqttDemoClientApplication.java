package com.yuansong.study.client1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.yuansong.tools.common.DateTool;

@SpringBootApplication(scanBasePackages="com.yuansong.study")
public class MqttDemoClientApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(MqttDemoClientApplication.class);
	
	public static void main(String[] args) {
		
		DateTool dt = new DateTool();
		logger.debug(dt.GetDatetimeWithMillionsecond());
		SpringApplication.run(MqttDemoClientApplication.class, args);
		logger.debug(dt.GetDatetimeWithMillionsecond());
	}
}
