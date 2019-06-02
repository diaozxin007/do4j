package com.xilidou.do4j.service;

import com.xilidou.do4j.utils.JsonUtils;
import com.xilidou.do4j.vo.BaseTimeVo;
import com.xilidou.do4j.vo.IntervalExtVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;

@Service
@Slf4j
public class TimeService {

	public String getIntervalExtFromActionTimeVo(BaseTimeVo timeVo){
		IntervalExtVo intervalExtVo = new IntervalExtVo();
		if(CollectionUtils.isNotEmpty(timeVo.getWeekOfMonth())) {
			intervalExtVo.setWeekOfMonth(timeVo.getWeekOfMonth());
		}
		if(CollectionUtils.isNotEmpty(timeVo.getDaysOfWeek())){
			intervalExtVo.setDaysOfWeek(timeVo.getDaysOfWeek());
		}
		return JsonUtils.write(intervalExtVo);
	}

	public IntervalExtVo getIntervalVoFromString(String str){
		if(StringUtils.isNotEmpty(str)){
			return JsonUtils.read(str, IntervalExtVo.class);

		}
		return null;
	}

}
