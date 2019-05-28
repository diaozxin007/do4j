package com.xilidou.do4j;

import cn.leancloud.core.AVOSCloud;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	private static String appId = System.getenv("LEANCLOUD_APP_ID");
	private static String appKey = System.getenv("LEANCLOUD_APP_KEY");

	public static void main(String[] args) {
		AVOSCloud.initialize(appId,appKey);
		SpringApplication.run(Application.class, args);
	}

}
