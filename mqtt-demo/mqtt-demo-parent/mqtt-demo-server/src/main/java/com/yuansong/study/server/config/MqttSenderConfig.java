package com.yuansong.study.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

import com.yuansong.study.common.config.MqttConfig;

@Configuration
@IntegrationComponentScan
public class MqttSenderConfig {
	
	@Autowired
	private MqttConfig mqttConfig;
	
	@Autowired
	private MqttPahoClientFactory mqttPahoClientFactory;
	
	@Bean
	public MessageChannel mqttOutboundChannel() {
		return new DirectChannel();
	}
	
	@Bean
	@ServiceActivator(inputChannel = "mqttOutboundChannel")
	public MessageHandler mqttOutbound() {
		MqttPahoMessageHandler messageHandler = new MqttPahoMessageHandler(this.mqttConfig.getClientId(),this.mqttPahoClientFactory);
		messageHandler.setAsync(true);
		messageHandler.setDefaultTopic(this.mqttConfig.getDefaultTopic());
		return messageHandler;
	}

}
