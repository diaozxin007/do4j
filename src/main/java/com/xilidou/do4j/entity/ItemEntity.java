package com.xilidou.do4j.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ItemEntity {

	private long id;

	private String title;

	private boolean marked;

	private String type;

	private long parentId;

	private long expectDurationTime;

	private long delayToTime;

	private long upToTime;


}
