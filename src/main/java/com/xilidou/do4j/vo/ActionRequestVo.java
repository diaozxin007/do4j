package com.xilidou.do4j.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.ToString;

import java.util.List;


/**
 * @author zhengxin
 */
@Data
@ToString
@ApiModel()
public class ActionRequestVo {

	private long id;

	private String title;

	private String description;

	private List<Long> tagIds;

	private long objectId;

	private int status;

	private boolean marked;

	private BaseTimeVo timeVo;

}
