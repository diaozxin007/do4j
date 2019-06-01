package com.xilidou.do4j.controller;

import com.google.common.collect.Lists;
import com.xilidou.do4j.vo.ActionResponseVo;
import com.xilidou.do4j.vo.ObjectRequestVo;
import com.xilidou.do4j.vo.ObjectResponseVo;
import com.xilidou.do4j.vo.ObjectSimpleResponseVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Zhengxin
 */
@RestController
@RequestMapping("/object")
public class ObjectController {


	@GetMapping("")
	@ApiOperation(value="获取object列表")
	public List<ObjectSimpleResponseVo> getObject(){
		return Lists.newArrayList(new ObjectSimpleResponseVo());
	}

	@GetMapping("/{id}")
	@ApiOperation(value="获取object详情")
	public ObjectResponseVo getObject(@PathVariable long id){
		return new ObjectResponseVo();
	}

	@PostMapping
	@ApiOperation(value="创建object")
	public ObjectResponseVo createObject(ObjectRequestVo requestVo){
		return new ObjectResponseVo();
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "修改 object")
	public ObjectResponseVo updateObject(ObjectRequestVo requestVo){
		return new ObjectResponseVo();
	}

	@GetMapping("/{id}/actions")
	@ApiOperation(value = "获取 object 下的列表")
	public List<ActionResponseVo> getActionList(@PathVariable long id){
		return Lists.newArrayList(new ActionResponseVo());
	}


}
