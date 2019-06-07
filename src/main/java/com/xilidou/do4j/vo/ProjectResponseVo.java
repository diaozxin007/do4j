package com.xilidou.do4j.vo;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author Zhengxin
 */
@Data
@ToString
public class ProjectResponseVo {

	private Long id;

	private String title;

	private Integer status;

	private Boolean marked;

	private Integer type;

	private Long parentId;

	private List<TagVo> tagIds;

	private BaseTimeVo timeVo;

	private String note;

}
