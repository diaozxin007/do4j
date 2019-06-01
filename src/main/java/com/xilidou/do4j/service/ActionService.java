package com.xilidou.do4j.service;

import com.xilidou.do4j.entity.ItemEntity;
import com.xilidou.do4j.repository.ItemRepository;
import com.xilidou.do4j.vo.ActionRequestVo;
import com.xilidou.do4j.vo.BaseTimeVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActionService {

	@Autowired
	private ItemRepository itemRepository;

	public ItemEntity get(long id){
		return itemRepository.getOne(id);
	}


	public void save(ActionRequestVo actionRequestVo){





	}

	private ItemEntity actionToItem(ActionRequestVo actionRequestVo){

		ItemEntity itemEntity = new ItemEntity();

		BeanUtils.copyProperties(actionRequestVo,itemEntity);

		BaseTimeVo timeVo = actionRequestVo.getTimeVo();

		
		return itemEntity;

	}

}
