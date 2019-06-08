package com.xilidou.do4j.controller;

import com.xilidou.do4j.service.UserService;
import com.xilidou.do4j.vo.UserRequestVo;
import com.xilidou.do4j.vo.UserResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/signin")
	public UserResponseVo signIn(@RequestBody @Valid UserRequestVo vo){
		UserResponseVo siginin = userService.signIn(vo);
		return siginin;

	}



	@PostMapping("/signup")
	public UserResponseVo signUp(@RequestBody UserRequestVo vo){

		return userService.signUp(vo);

	}

	@PostMapping("/refresh")
	public UserResponseVo refresh(@RequestBody UserRequestVo vo){
		return null;

	}

}
