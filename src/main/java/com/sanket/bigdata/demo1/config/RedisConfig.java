package com.sanket.bigdata.demo1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.sanket.bigdata.demo1.domain.Plan;
import com.sanket.bigdata.demo1.repository.PersonRepository;

@Configuration
public class RedisConfig {

	@Bean
	public PersonRepository repository(RedisTemplate<String, Plan> redisTemplate) {
		return new PersonRepository(redisTemplate);
	}

	@Bean
	public RedisTemplate<String, Plan> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
		RedisTemplate<String, Plan> template = new RedisTemplate();

		template.setConnectionFactory(redisConnectionFactory);

		RedisSerializer<String> stringSerializer = new StringRedisSerializer();
		RedisSerializer<Plan> personSerializer = new Jackson2JsonRedisSerializer<>(Plan.class);

		template.setKeySerializer(stringSerializer);
		template.setValueSerializer(personSerializer);
		template.setHashKeySerializer(stringSerializer);
		template.setHashValueSerializer(personSerializer);

		return template;
	}
}
