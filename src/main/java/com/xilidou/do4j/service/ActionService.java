package com.xilidou.do4j.service;

import com.xilidou.do4j.entity.ItemEntity;
import com.xilidou.do4j.repository.ItemRepository;
import com.xilidou.do4j.utils.JsonUtils;
import com.xilidou.do4j.vo.ActionRequestVo;
import com.xilidou.do4j.vo.BaseTimeVo;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ActionService {

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private TimeService timeService;

	public ItemEntity get(long id){
		return itemRepository.getOne(id);
	}


	public long save(ActionRequestVo actionRequestVo){

		ItemEntity itemEntity = actionToItem(actionRequestVo);

		ItemEntity save = itemRepository.save(itemEntity);

		return save.getId();


	}

	private ItemEntity actionToItem(ActionRequestVo actionRequestVo){

		ItemEntity itemEntity = new ItemEntity();

		BeanUtils.copyProperties(actionRequestVo,itemEntity);

		BaseTimeVo timeVo = actionRequestVo.getTimeVo();

		itemEntity.setCanRepeat(timeVo.getCanRepeat());
		itemEntity.setExpectDuration(timeVo.getExpectDuration());
		itemEntity.setDelayToTime(timeVo.getDelayToTime());
		itemEntity.setUpToTime(timeVo.getUpToTime());
		itemEntity.setIntervalUnit(timeVo.getIntervalUnit());
		itemEntity.setIntervalValue(timeVo.getReviewIntervalValue());


		String intervalExt = timeService.getIntervalExtFromActionTimeVo(timeVo);
		itemEntity.setIntervalExt(intervalExt);

		List<LocalDateTime> noticeTimes = timeVo.getNoticeTimes();
		if(CollectionUtils.isNotEmpty(noticeTimes)){
			String notice = JsonUtils.write(noticeTimes);
			itemEntity.setNoticeDetail(notice);
		}


		return itemEntity;

	}



}
