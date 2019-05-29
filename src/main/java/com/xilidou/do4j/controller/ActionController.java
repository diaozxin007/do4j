package com.xilidou.do4j.controller;

import com.google.common.collect.Lists;
import com.xilidou.do4j.entity.ItemEntity;
import com.xilidou.do4j.service.ActionService;
import com.xilidou.do4j.vo.ActionRequestVo;
import com.xilidou.do4j.vo.ActionResponseVo;
import com.xilidou.do4j.vo.ResultVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zhengxin
 */
@RestController
@RequestMapping("/actions")
public class ActionController {

	@Autowired
	private ActionService actionService;

	@GetMapping("/{id}")
	@ApiOperation(value="获取action详情")
	public ActionResponseVo getAction(@PathVariable long id){
		ActionResponseVo actionVo = new ActionResponseVo();
		ItemEntity itemEntity = actionService.get(id);
		BeanUtils.copyProperties(itemEntity,actionVo);
		return actionVo;
	}

	@GetMapping("")
	@ApiOperation(value="获取action列表")
	public List<ActionResponseVo> getActions(){
		ActionResponseVo actionVo = new ActionResponseVo();
		return Lists.newArrayList(actionVo);
	}

	@PostMapping("")
	@ApiOperation(value="创建")
	public ResultVo createActon(ActionRequestVo actionVo){
		return new ResultVo();
	}

	@PutMapping("/{id}")
	@ApiOperation(value="修改")
	public ResultVo modifyActon(@PathVariable long id){
		return new ResultVo();
	}

}
