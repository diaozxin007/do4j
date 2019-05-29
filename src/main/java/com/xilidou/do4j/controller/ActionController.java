package com.xilidou.do4j.controller;

import com.xilidou.do4j.entity.ItemEntity;
import com.xilidou.do4j.service.ActionService;
import com.xilidou.do4j.vo.ActionVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhengxin
 */
@RestController
@RequestMapping("/actions")
public class ActionController {

	@Autowired
	private ActionService actionService;

	@GetMapping("/{id}")
	@ApiOperation(value="获取用户信息")
	public ActionVo getAction(@PathVariable long id){
		ActionVo actionVo = new ActionVo();
		ItemEntity itemEntity = actionService.get(id);
		BeanUtils.copyProperties(itemEntity,actionVo);
		return actionVo;
	}

}
