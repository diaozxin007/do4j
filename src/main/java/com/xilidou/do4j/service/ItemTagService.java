package com.xilidou.do4j.service;

import com.xilidou.do4j.entity.ItemTagEntity;
import com.xilidou.do4j.repository.ItemTagRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Zhengxin
 */
@Service
@Slf4j
public class ItemTagService {

	@Autowired
	private ItemTagRepository itemTagRepository;

	public List<ItemTagEntity>  save(List<ItemTagEntity> itemTagEntities){
		return itemTagRepository.saveAll(itemTagEntities);
	}

	public void deleteByItemIds(List<Long> itemIds){
		itemTagRepository.deleteByItemIdIn(itemIds);
	}

	public List<ItemTagEntity> findByItemId(long itemId){
		return findByItemId(itemId);
	}

	public void saveItemTag(List<Long> tagIds, Long itemId) {
		// 标签不为空
		if (CollectionUtils.isNotEmpty(tagIds)) {
			List<ItemTagEntity> collect = tagIds.stream().map(t -> {
				ItemTagEntity itemTagEntity = new ItemTagEntity();
				itemTagEntity.setTagId(t);
				itemTagEntity.setItemId(itemId);
				return itemTagEntity;
			}).collect(Collectors.toList());

			save(collect);
		}
	}


}
