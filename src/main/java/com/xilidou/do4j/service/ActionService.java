package com.xilidou.do4j.service;

import com.xilidou.do4j.entity.ItemEntity;
import com.xilidou.do4j.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActionService {

	@Autowired
	private ItemRepository itemRepository;

	public ItemEntity get(long id){
		return itemRepository.getOne(id);
	}

}
