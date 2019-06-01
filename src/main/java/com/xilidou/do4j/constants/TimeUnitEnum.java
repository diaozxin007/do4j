package com.xilidou.do4j.constants;


import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Zhengxin
 */

public enum  TimeUnitEnum {

	Day(1,"天"),
	Month(2,"月"),
	Year(3,"年"),

	Hour(4,"小时"),
	Minute(5,"分"),
	Secend(6,"秒");



	private int unit;
	private String name;

	private TimeUnitEnum(int unit, String name) {
		this.unit = unit;
		this.name = name;
	}

}
