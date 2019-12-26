package com.yuansong.study.client1.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageProducer;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;

import com.yuansong.study.common.config.MqttConfig;

@Configuration
@IntegrationComponentScan
public class MqttReceiveConfig {
	
	private static final Logger logger = LoggerFactory.getLogger(MqttReceiveConfig.class);

	@Autowired
	private MqttConfig mqttConfig;
	
	@Autowired
	private MqttPahoClientFactory mqttPahoClientFactory;
	
	@Bean
	public MessageChannel mqttInputChannel() {
		return new DirectChannel();
	}
	
	@Bean
	public MqttPahoMessageDrivenChannelAdapter getMqttPahoMessageDrivenChannelAdapter() {
		String cId = this.mqttConfig.getClientId() + "_inbound";
		MqttPahoMessageDrivenChannelAdapter adapter =
				new MqttPahoMessageDrivenChannelAdapter(cId, this.mqttPahoClientFactory);
		adapter.setCompletionTimeout(this.mqttConfig.getCompletionTimeout());
		adapter.setConverter(new DefaultPahoMessageConverter());
		adapter.setQos(1);
		adapter.setOutputChannel(mqttInputChannel());
		return adapter;
	}
	
	@Bean
	public MessageProducer inbound() {
		return getMqttPahoMessageDrivenChannelAdapter();
	}
	
	@Bean
	@ServiceActivator(inputChannel = "mqttInputChannel")
	public MessageHandler handler() {
		return new MessageHandler() {

			@Override
			public void handleMessage(Message<?> message) throws MessagingException {
				String topic = message.getHeaders().get("mqtt_receivedTopic").toString();
				logger.debug("===================================");
				logger.debug("Receive Message");
				logger.debug(topic);
                logger.debug("msg: " + message.getPayload().toString());
                logger.debug("===================================");
			}
		};
	}
}
