package com.xilidou.do4j.service;

import com.xilidou.do4j.entity.ItemEntity;
import com.xilidou.do4j.entity.ItemTagEntity;
import com.xilidou.do4j.repository.ItemRepository;
import com.xilidou.do4j.utils.JsonUtils;
import com.xilidou.do4j.vo.ActionRequestVo;
import com.xilidou.do4j.vo.ActionResponseVo;
import com.xilidou.do4j.vo.BaseTimeVo;
import com.xilidou.do4j.vo.IntervalExtVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
	private TimeService timeService;

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

		saveItemTag(tagIds, id);

		return save.getId();

	}

	private void saveItemTag(List<Long> tagIds, Long itemId) {
		// 标签不为空
		if (CollectionUtils.isNotEmpty(tagIds)) {
			List<ItemTagEntity> collect = tagIds.stream().map(t -> {
				ItemTagEntity itemTagEntity = new ItemTagEntity();
				itemTagEntity.setTagId(t);
				itemTagEntity.setItemId(itemId);
				return itemTagEntity;
			}).collect(Collectors.toList());

			itemTagService.save(collect);
		}
	}

	private ItemEntity actionToItem(ActionRequestVo actionRequestVo) {

		ItemEntity itemEntity = new ItemEntity();

		BeanUtils.copyProperties(actionRequestVo, itemEntity);

		itemEntity.setType("action");

		BaseTimeVo timeVo = actionRequestVo.getTimeVo();

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

	private ActionResponseVo itemToResponseVo(ItemEntity itemEntity) {

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

		ActionResponseVo actionResponseVo = new ActionResponseVo();

		BeanUtils.copyProperties(itemEntity,actionResponseVo);

		actionResponseVo.setTimeVo(baseTimeVo);

		return actionResponseVo;
	}

}
