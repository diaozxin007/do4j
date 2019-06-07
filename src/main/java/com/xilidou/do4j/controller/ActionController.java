package com.xilidou.do4j.controller;

import com.google.common.collect.Lists;
import com.xilidou.do4j.entity.ItemEntity;
import com.xilidou.do4j.service.ActionService;
import com.xilidou.do4j.vo.ActionRequestVo;
import com.xilidou.do4j.vo.ActionResponseVo;
import com.xilidou.do4j.vo.ResultVo;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zhengxin
 */
@RestController
@RequestMapping("/actions")
@Slf4j
public class ActionController {

	@Autowired
	private ActionService actionService;

	@GetMapping("/{id}")
	@ApiOperation(value = "获取action详情")
	public ActionResponseVo getAction(@PathVariable long id) {
		log.info("get id is {}",id);
		return actionService.get(id);
	}

	@GetMapping("")
	@ApiOperation(value = "获取action列表")
	public List<ActionResponseVo> getActions() {
		return actionService.findByStatus(null);
	}

	@PostMapping("")
	@ApiOperation(value = "创建")
	@ResponseStatus(HttpStatus.CREATED)
	public ResultVo createActon(@RequestBody ActionRequestVo actionVo) {
		long saveId = actionService.save(actionVo);
		ResultVo resultVo = new ResultVo();
		resultVo.setId(saveId);
		return resultVo;
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "修改")
	public ResultVo modifyActon(@PathVariable long id) {
		return new ResultVo();
	}

}
