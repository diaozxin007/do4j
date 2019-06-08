package com.xilidou.do4j.controller;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

public class BaseController {

	@Autowired
	private HttpServletRequest request;

	public long getUid(){

		return (long) request.getAttribute("uid");

	}

}
