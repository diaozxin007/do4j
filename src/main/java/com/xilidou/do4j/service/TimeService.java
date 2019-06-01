package com.xilidou.do4j.service;

import com.xilidou.do4j.utils.JsonUtils;
import com.xilidou.do4j.vo.BaseTimeVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class TimeService {

	public String getIntervalExtFromActionTimeVo(BaseTimeVo timeVo){

		Map<String,Object> jsonMap = new HashMap<>();

		if(CollectionUtils.isNotEmpty(timeVo.getWeekOfMonth())) {
			jsonMap.put("weekOfMonth", timeVo.getWeekOfMonth());
		}

		if(CollectionUtils.isNotEmpty(timeVo.getDaysOfWeek())){
			jsonMap.put("deysOfWeek",timeVo.getDaysOfWeek());
		}

		return JsonUtils.write(jsonMap);

	}

}
