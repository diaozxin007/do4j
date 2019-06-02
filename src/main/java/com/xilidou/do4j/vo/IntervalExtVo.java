package com.xilidou.do4j.vo;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class IntervalExtVo {

	private List<Integer> weekOfMonth;

	private List<Integer> daysOfWeek;

}
