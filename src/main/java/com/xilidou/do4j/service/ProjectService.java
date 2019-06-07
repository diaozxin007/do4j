package com.xilidou.do4j.service;

import com.google.common.collect.Lists;
import com.xilidou.do4j.constants.Const;
import com.xilidou.do4j.entity.ItemEntity;
import com.xilidou.do4j.repository.ItemRepository;
import com.xilidou.do4j.vo.BaseTimeVo;
import com.xilidou.do4j.vo.ProjectRequestVo;
import com.xilidou.do4j.vo.ProjectResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProjectService {

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private ItemService itemService;

	@Autowired
	private ItemTagService itemTagService;

	public ProjectResponseVo get(long id){
		Optional<ItemEntity> byId = itemRepository.findById(id);
		return byId.map(this::itemToResponseVo).orElse(null);
	}

	public long save(ProjectRequestVo vo){
		ItemEntity itemEntity = projectToItem(vo);
		ItemEntity save = itemRepository.save(itemEntity);
		long id = save.getId();
		List<Long> tagIds = vo.getTagIds();
		itemTagService.saveItemTag(tagIds, id);
		return save.getId();

	}

	public long update(ProjectRequestVo vo){
		ItemEntity itemEntity = projectToItem(vo);
		ItemEntity save = itemRepository.save(itemEntity);
		long id = save.getId();
		List<Long> tagIds = vo.getTagIds();
		itemTagService.deleteByItemIds(Lists.newArrayList(id));
		itemTagService.saveItemTag(tagIds,id);
		return save.getId();
	}

	public List<ProjectResponseVo> findByStatus(List<Integer> statusList){
		if(CollectionUtils.isEmpty(statusList)){
			statusList = Lists.newArrayList(Const.Status.ACTIVE);
		}
		List<ItemEntity> itemEntityList = itemRepository.findAllByTypeAndStatusIn(Const.ItemType.Project.type, statusList);
		return itemEntityList.stream().map(this::itemToResponseVo).collect(Collectors.toList());

	}

	public List<ProjectResponseVo> findChildrenById(long id){
		List<ItemEntity> itemEntityList = itemService.getAllChildItemById(id);
		return itemEntityList.stream().map(this::itemToResponseVo).collect(Collectors.toList());
	}



	private ProjectResponseVo itemToResponseVo(ItemEntity itemEntity) {
		ProjectResponseVo projectResponseVo = new ProjectResponseVo();
		BeanUtils.copyProperties(itemEntity,projectResponseVo);
		BaseTimeVo baseTimeVoFromItem = itemService.getBaseTimeVoFromItem(itemEntity);
		projectResponseVo.setTimeVo(baseTimeVoFromItem);
		return projectResponseVo;
	}

	private ItemEntity projectToItem(ProjectRequestVo vo) {
		ItemEntity itemEntity = new ItemEntity();
		BeanUtils.copyProperties(vo, itemEntity);

		Long parentId = vo.getParentId();
		if(parentId != null && parentId > 0){
			String pathFromParent = itemService.getLevelPathFromParentId(parentId);
			itemEntity.setLevelPath(pathFromParent);
		}
		itemEntity.setType(Const.ItemType.Project.type);
		return itemService.fullTime(itemEntity, vo.getTimeVo());

	}

}
