package com.xilidou.do4j.service;

import com.google.common.collect.Lists;
import com.xilidou.do4j.constants.Const;
import com.xilidou.do4j.entity.ItemEntity;
import com.xilidou.do4j.repository.ItemRepository;
import com.xilidou.do4j.vo.ActionRequestVo;
import com.xilidou.do4j.vo.ActionResponseVo;
import com.xilidou.do4j.vo.BaseTimeVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Zhengxin
 */
@Service
@Slf4j
public class ActionService {

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private ItemService itemService;

	@Autowired
	private ItemTagService itemTagService;

	public ActionResponseVo get(long id) {
		Optional<ItemEntity> byId = itemRepository.findById(id);
		return byId.map(this::itemToResponseVo).orElse(null);

	}

	public long save(ActionRequestVo actionRequestVo) {
		ItemEntity itemEntity = actionToItem(actionRequestVo);
		ItemEntity save = itemRepository.save(itemEntity);
		long id = save.getId();
		List<Long> tagIds = actionRequestVo.getTagIds();
		itemTagService.saveItemTag(tagIds, id);
		return save.getId();

	}

	public long update(ActionRequestVo actionRequestVo){
		ItemEntity itemEntity = actionToItem(actionRequestVo);
		ItemEntity save = itemRepository.save(itemEntity);
		long id = save.getId();
		List<Long> tagIds = actionRequestVo.getTagIds();
		itemTagService.deleteByItemIds(Lists.newArrayList(id));
		itemTagService.saveItemTag(tagIds,id);
		return save.getId();
	}

	public List<ActionResponseVo> findByStatus(List<Integer> statusList){

		if(CollectionUtils.isEmpty(statusList)){
			statusList = Lists.newArrayList(Const.Status.ACTIVE);
		}

		List<ItemEntity> itemEntityList = itemRepository.findAllByTypeAndStatusIn(Const.ItemType.Action.type, statusList);
		return itemEntityList.stream().map(this::itemToResponseVo).collect(Collectors.toList());

	}

	private ItemEntity actionToItem(ActionRequestVo actionRequestVo) {
		ItemEntity itemEntity = new ItemEntity();
		BeanUtils.copyProperties(actionRequestVo, itemEntity);
		itemEntity.setType(Const.ItemType.Action.type);
		return itemService.fullTime(itemEntity, actionRequestVo.getTimeVo());

	}

	private ActionResponseVo itemToResponseVo(ItemEntity itemEntity) {
		ActionResponseVo actionResponseVo = new ActionResponseVo();
		BeanUtils.copyProperties(itemEntity,actionResponseVo);
		BaseTimeVo baseTimeVoFromItem = itemService.getBaseTimeVoFromItem(itemEntity);
		actionResponseVo.setTimeVo(baseTimeVoFromItem);
		return actionResponseVo;
	}

}
