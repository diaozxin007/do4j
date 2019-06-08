package com.xilidou.do4j.auth;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.concurrent.TimeUnit;

@Configuration
public class CacheConfig {

	@Bean
	public Cache<String, UserDetails> cache(){

		return Caffeine.newBuilder()
				.expireAfterWrite(10, TimeUnit.MINUTES)
//				.refreshAfterWrite(10, TimeUnit.MINUTES)
				.build();

	}

}
