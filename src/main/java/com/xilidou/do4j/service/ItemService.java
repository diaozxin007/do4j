package com.xilidou.do4j.service;

import com.google.common.collect.Lists;
import com.xilidou.do4j.constants.Const;
import com.xilidou.do4j.entity.ItemEntity;
import com.xilidou.do4j.repository.ItemRepository;
import com.xilidou.do4j.utils.JsonUtils;
import com.xilidou.do4j.vo.BaseTimeVo;
import com.xilidou.do4j.vo.IntervalExtVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ItemService {

	@Autowired
	private TimeService timeService;

	@Autowired
	private ItemRepository itemRepository;

	public String getLevelPathFromParentId(long parentId){
		Optional<ItemEntity> byId = itemRepository.findById(parentId);
		if (byId.isPresent()){
			ItemEntity itemEntity = byId.get();
			return itemEntity.getLevelPath() + parentId + ".";
		}else {
			return parentId + ".";
		}

	}

	public ItemEntity fullTime(ItemEntity itemEntity, BaseTimeVo timeVo) {

		if (timeVo != null) {
			itemEntity.setCanRepeat(timeVo.getCanRepeat());
			itemEntity.setExpectDuration(timeVo.getExpectDuration());
			itemEntity.setDelayToTime(timeVo.getDelayToTime());
			itemEntity.setUpToTime(timeVo.getUpToTime());
			itemEntity.setIntervalUnit(timeVo.getIntervalUnit());
			itemEntity.setIntervalValue(timeVo.getReviewIntervalValue());

			String intervalExt = timeService.getIntervalExtFromActionTimeVo(timeVo);
			itemEntity.setIntervalExt(intervalExt);

			List<LocalDateTime> noticeTimes = timeVo.getNoticeTimes();
			if (CollectionUtils.isNotEmpty(noticeTimes)) {
				String notice = JsonUtils.write(noticeTimes);
				itemEntity.setNoticeDetail(notice);
			}
		}
		return itemEntity;
	}

	public List<ItemEntity> getAllChildItemById(long id){
		List<Integer> status = Lists.newArrayList(Const.Status.ACTIVE, Const.Status.PASUD);
		return getAllChildItemById(id,status);
	}


	public List<ItemEntity> getAllChildItemById(long id,List<Integer> status){
		Optional<ItemEntity> byId = itemRepository.findById(id);
		if(CollectionUtils.isEmpty(status)){
			status = Lists.newArrayList(Const.Status.ACTIVE, Const.Status.PASUD);
		}

		if(byId.isPresent()){

			ItemEntity itemEntity = byId.get();

			String levelPath = itemEntity.getLevelPath();
			levelPath = levelPath + itemEntity.getId() + ".";
			return itemRepository.findAllByLevelPathStartingWithAndStatusIn(levelPath, status);
		}else {
			return new ArrayList<>();
		}

	}

	public BaseTimeVo getBaseTimeVoFromItem(ItemEntity itemEntity){

		BaseTimeVo baseTimeVo = new BaseTimeVo();


		baseTimeVo.setCanRepeat(itemEntity.getCanRepeat());
		baseTimeVo.setExpectDuration(itemEntity.getExpectDuration());
		baseTimeVo.setDelayToTime(itemEntity.getDelayToTime());
		baseTimeVo.setUpToTime(itemEntity.getUpToTime());
		baseTimeVo.setIntervalUnit(itemEntity.getIntervalUnit());
		baseTimeVo.setIntervalValue(itemEntity.getReviewIntervalValue());

		IntervalExtVo intervalExtVo = timeService.getIntervalVoFromString(itemEntity.getIntervalExt());
		if(intervalExtVo != null){
			baseTimeVo.setDaysOfWeek(intervalExtVo.getDaysOfWeek());
			baseTimeVo.setWeekOfMonth(intervalExtVo.getWeekOfMonth());
		}

		return baseTimeVo;

	}

}
