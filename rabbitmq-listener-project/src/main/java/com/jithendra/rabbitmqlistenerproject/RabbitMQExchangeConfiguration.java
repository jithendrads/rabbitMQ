package com.jithendra.rabbitmqlistenerproject;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class RabbitMQExchangeConfiguration {
	
	@Bean
	Exchange exampleExchange()
	{
		return new TopicExchange("ExampleExchange");
	}
	
	@Bean
	Exchange example2ndExchange()
	{
		return ExchangeBuilder.directExchange("Exchange2ndExample")
				.autoDelete()
				.internal()
				.build();
	}
	
	@Bean
	Exchange newExchange()
	{
		return ExchangeBuilder.topicExchange("TopicTestExchange")
				.autoDelete()
				.internal()
				.durable(true)
				.build();
				
	}
	
	@Bean
	Exchange fanoutExchange()
	{
		return ExchangeBuilder.fanoutExchange("FanOutExchange")
				.autoDelete()
				.internal()
				.durable(false)
				.build();
	}
	
	@Bean
	Exchange headerExchange()
	{
		return ExchangeBuilder.headersExchange("HeadersExchange")
				.ignoreDeclarationExceptions()	
				.internal()
				.durable(true)
				.build();
	}
	

}
