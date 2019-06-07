package com.xilidou.do4j.service;

import com.xilidou.do4j.entity.ItemTagEntity;
import com.xilidou.do4j.repository.ItemTagRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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


}
