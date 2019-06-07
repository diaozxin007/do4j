package com.xilidou.do4j.controller;

import com.xilidou.do4j.service.ProjectService;
import com.xilidou.do4j.vo.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Zhengxin
 */
@RestController
@RequestMapping("/projects")
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@GetMapping("")
	@ApiOperation(value="获取projects列表")
	public List<ProjectResponseVo> getProject(){
		List<ProjectResponseVo> voList = projectService.findByStatus(null);
		return voList;
	}

	@GetMapping("/{id}")
	@ApiOperation(value="获取projects详情")
	public ProjectResponseVo getProject(@PathVariable long id){
		return projectService.get(id);
	}

	@PostMapping
	@ApiOperation(value="创建projects")
	@ResponseStatus(HttpStatus.CREATED)
	public ResultVo createProject(@RequestBody ProjectRequestVo requestVo){
		long save = projectService.save(requestVo);
		ResultVo resultVo = new ResultVo();
		requestVo.setId(save);
		return resultVo;
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "修改 projects")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public ResultVo updateProject(@PathVariable long id,@RequestBody ProjectRequestVo requestVo){
		requestVo.setId(id);
		long update = projectService.update(requestVo);
		ResultVo resultVo = new ResultVo();
		resultVo.setId(update);
		return resultVo;
	}

	@GetMapping("/{id}/actions")
	@ApiOperation(value = "获取 projects 下的列表")
	public List<ProjectResponseVo> getActionList(@PathVariable long id){
		return projectService.findChildrenById(id);
	}


}
