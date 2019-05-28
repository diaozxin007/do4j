package com.xilidou.do4j.controller;

import com.xilidou.do4j.vo.ActionVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/action")
public class ActionController {

	@GetMapping("/{id}")
	@ApiOperation(value="获取用户信息")
	public ActionVo getAction(@PathVariable String id){
		return new ActionVo();
	}

}
