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

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Zhengxin
 */
@RestController
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping("/{userId}")
    @ResponseBody
    @ApiOperation(value = "根据用户id获取用户所有标签")
    public List<TagVo> findUserAllTags(long userId){
        List<TagEntity> allByUserId = tagService.findAllByUserId(userId);
        List<TagVo> resultVo = Lists.newArrayList();
        if (CollectionUtils.isNotEmpty(allByUserId)){
            resultVo = allByUserId.stream().map(i -> entityToVo(i)).collect(Collectors.toList());
        }
        return resultVo;
    }

    private TagVo entityToVo(TagEntity entity){
        TagVo tagVo = new TagVo();
        BeanUtils.copyProperties(entity,tagVo);
        return tagVo;
    }
}
