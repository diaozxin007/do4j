package com.xilidou.do4j.controller;

import com.google.common.collect.Lists;
import com.xilidou.do4j.vo.ActionResponseVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Zhengxin
 */
@RestController
@RequestMapping("/object")
public class ObjectController {


	@GetMapping("")
	@ApiOperation(value="获取object列表")
	public List<ActionResponseVo> getActions(){
		ActionResponseVo actionVo = new ActionResponseVo();
		return Lists.newArrayList(actionVo);
	}

	@GetMapping("/{id}")
	@ApiOperation(value="获取object列表")
	public ActionResponseVo getAction(@PathVariable long id){
		return new ActionResponseVo();
	}


}
