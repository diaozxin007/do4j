package com.xilidou.do4j.vo;

import lombok.Data;
import lombok.ToString;

import java.util.List;


@Data
@ToString
public class ActionRequestVo {

	private String title;

	private String describtion;

	private Long objectId;

	private List<Long> tagIds;

}
