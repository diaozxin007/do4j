package com.xilidou.do4j.vo;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class ProjectSimpleResponseVo {

	private String title;

	private List<TagVo> tagList;

	private Boolean marked;

	private Long remainedActionNumber;

}
