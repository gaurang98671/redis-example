package com.redisexample.redisexample;

import com.redisexample.redisexample.models.Users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@EnableCaching
@SpringBootApplication

public class RedisExampleApplication {

	@Bean
	JedisConnectionFactory getFactory()
	{
		RedisProperties redisProperties= getProperties();
		RedisStandaloneConfiguration redisConfiguration= new RedisStandaloneConfiguration();
		redisConfiguration.setHostName(redisProperties.getHost());
		redisConfiguration.setPort(redisProperties.getPort());

		return new JedisConnectionFactory(redisConfiguration);
	}

	@Bean
	RedisTemplate<String, Users> getTemplate()
	{
		RedisTemplate<String, Users> newTamplate= new RedisTemplate<>();

		newTamplate.setConnectionFactory(getFactory());
		return newTamplate;
	}

	@Bean
	@Primary
	RedisProperties getProperties()
	{
		return new RedisProperties();
	}

	public static void main(String[] args) {
		
		SpringApplication.run(RedisExampleApplication.class, args);
	}

}
