package com.xilidou.do4j.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class JsonUtils {

	private static ObjectMapper objectMapper = new ObjectMapper();

	public static String write(Object o){
		try {
			return objectMapper.writeValueAsString(o);
		} catch (JsonProcessingException e) {
			log.error("write json error",e);
		}
		return null;

	}

	public static  <T> T read(String json,Class<T> clz){
		try {
			return objectMapper.readValue(json,clz);
		} catch (IOException e) {
			log.error("read json error {}",json,e);
		}

		return null;
	}

}
