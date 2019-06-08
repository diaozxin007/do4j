package com.xilidou.do4j.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author Zhengxin
 */
@Data
@ToString
@ApiModel
public class ProjectRequestVo {

	private Long id;

	private Long userId;

	private String title;

	private Integer status;

	private Boolean marked;

	private Integer type;

	private Long parentId;

	private List<Long> tagIds;

	private BaseTimeVo timeVo;

	private String note;
}
