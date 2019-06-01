package com.xilidou.do4j.service;

import com.xilidou.do4j.constants.Const;
import com.xilidou.do4j.entity.TagEntity;
import com.xilidou.do4j.repository.TagRepository;
import com.xilidou.do4j.vo.TagVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: renmagical
 * @Date: 2019-06-01 22:43
 * @Description: 标签Service
 */
@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    public List<TagEntity> findAllByUserId(long userId){
        return tagRepository.findByUserId(userId);
    }

    public List<TagEntity> findActiveByUserId(long userId){
        return tagRepository.findByUserIdAndStatus(userId, Const.Status.ACTIVE);
    }

    public TagEntity getById(long id){
        return tagRepository.getOne(id);
    }

    /**
     * 添加标签
     * @param tagVo 标签Vo
     */
    public void addTag(TagVo tagVo){
        tagRepository.save(voToEntity(tagVo));
    }

    /**
     * 修改标签
     * @param tagVo 标签Vo
     */
    public void updateTag(TagVo tagVo){
        TagEntity existTag = getById(tagVo.getId());
        if (existTag != null && existTag.getId() > 0){
            tagRepository.save(voToEntity(tagVo));
        }
    }

    private TagEntity voToEntity(TagVo vo){
        TagEntity tagEntity = new TagEntity();
        BeanUtils.copyProperties(vo,tagEntity);
        return tagEntity;
    }
}
