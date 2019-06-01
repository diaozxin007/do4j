package com.xilidou.do4j.controller;

import com.google.common.collect.Lists;
import com.xilidou.do4j.entity.TagEntity;
import com.xilidou.do4j.service.TagService;
import com.xilidou.do4j.vo.TagVo;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.xilidou.do4j.service.TagService;
import com.xilidou.do4j.vo.ResultVo;
import com.xilidou.do4j.vo.TagVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Zhengxin
 */
@RestController
@RequestMapping("/tags")
public class TagController {

	@Autowired
	private TagService tagService;

	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public ResultVo createdTag(TagVo tagVo){

		long save = tagService.save(tagVo);

		ResultVo resultVo = new ResultVo();

		resultVo.setId(save);

		return resultVo;

	}

	@GetMapping("/")
	public List<TagVo> getTags(){

		return tagService.getAll();

	}



}
