package com.yuansong.study.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.yuansong.tools.common.DateTool;

@SpringBootApplication(scanBasePackages="com.yuansong.study")
public class MqttDemoServerApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(MqttDemoServerApplication.class); 

	public static void main(String[] args) {
		
		DateTool dt = new DateTool();
		logger.debug(dt.GetDatetimeWithMillionsecond());
		SpringApplication.run(MqttDemoServerApplication.class, args);
		logger.debug(dt.GetDatetimeWithMillionsecond());
	}

}
