package com.xilidou.do4j.service;

import com.xilidou.do4j.entity.TagEntity;
import com.xilidou.do4j.repository.TagRepository;
import com.xilidou.do4j.vo.TagVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Zhengxin
 */
@Service
@Slf4j
public class TagService {

	@Autowired
	private TagRepository tagRepository;

	public long save(TagVo tagVo){
		TagEntity tagEntity = new TagEntity();
		BeanUtils.copyProperties(tagVo,tagEntity);
		TagEntity save = tagRepository.save(tagEntity);
		return save.getId();

	}

	public List<TagVo> getAll(){
		List<TagEntity> tagEntityList = tagRepository.findAll();
		return getTagVos(tagEntityList);
	}

	private List<TagVo> getTagVos(List<TagEntity> tagEntityList) {
		if(CollectionUtils.isNotEmpty(tagEntityList)){
			return tagEntityList.stream().map(t->{
				TagVo tagVo = new TagVo();
				BeanUtils.copyProperties(t,tagVo);
				return tagVo;
			}).collect(Collectors.toList());
		}
		return new ArrayList<>();
	}

	public List<TagVo> findByIds(List<Long> ids){
		List<TagEntity> allByIdIn = tagRepository.getAllByIdIn(ids);
		return getTagVos(allByIdIn);
	}

}
