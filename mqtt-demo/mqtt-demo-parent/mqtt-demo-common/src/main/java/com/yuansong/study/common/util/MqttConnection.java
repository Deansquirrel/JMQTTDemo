package com.yuansong.study.common.util;

import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;

import com.yuansong.study.common.config.MqttConfig;

@Configuration
public class MqttConnection {
	
	@Autowired
	private MqttConfig mqttConfig;
	
	@Bean
	public MqttConnectOptions getMqttConnectOptions() {
		MqttConnectOptions mqttConnectOptions = new MqttConnectOptions();
		mqttConnectOptions.setUserName(mqttConfig.getUsername());
		mqttConnectOptions.setPassword(mqttConfig.getPassword().toCharArray());
		mqttConnectOptions.setServerURIs(new String[] {mqttConfig.getHostUrl()});
		mqttConnectOptions.setKeepAliveInterval(2);
		return mqttConnectOptions;
	}
	
	@Bean
	public MqttPahoClientFactory mqttClientFactory() {
		DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
		factory.setConnectionOptions(getMqttConnectOptions());
		return factory;
	}	
}
