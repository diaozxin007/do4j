package com.xilidou.do4j.entity;

import cn.leancloud.AVObject;
import cn.leancloud.annotation.AVClassName;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AVClassName("item")
public class ItemEntity extends AVObject {

	private String id;

	private String title;

	private boolean marked;

	private String type;

	private long parentId;

	private long expectDurationTime;

	private long delayToTime;

	private long upToTime;


}
