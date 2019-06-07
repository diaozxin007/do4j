package com.xilidou.do4j.controller;

import com.google.common.collect.Lists;
import com.xilidou.do4j.vo.ActionResponseVo;
import com.xilidou.do4j.vo.ProjectRequestVo;
import com.xilidou.do4j.vo.ProjectResponseVo;
import com.xilidou.do4j.vo.ProjectSimpleResponseVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Zhengxin
 */
@RestController
@RequestMapping("/projects")
public class ProjectController {


	@GetMapping("")
	@ApiOperation(value="获取projects列表")
	public List<ProjectSimpleResponseVo> getObject(){
		return Lists.newArrayList(new ProjectSimpleResponseVo());
	}

	@GetMapping("/{id}")
	@ApiOperation(value="获取projects详情")
	public ProjectResponseVo getObject(@PathVariable long id){
		return new ProjectResponseVo();
	}

	@PostMapping
	@ApiOperation(value="创建projects")
	public ProjectResponseVo createObject(ProjectRequestVo requestVo){
		return new ProjectResponseVo();
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "修改 projects")
	public ProjectResponseVo updateObject(ProjectRequestVo requestVo){
		return new ProjectResponseVo();
	}

	@GetMapping("/{id}/actions")
	@ApiOperation(value = "获取 projects 下的列表")
	public List<ActionResponseVo> getActionList(@PathVariable long id){
		return Lists.newArrayList(new ActionResponseVo());
	}


}
