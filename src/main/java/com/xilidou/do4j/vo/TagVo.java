package com.xilidou.do4j.vo;


import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @author Zhengxin
 */
@Data
@ToString
public class TagVo {

	private Long tagId;

	private String title;

	private Integer status;

	private Integer parentId;

	private LocalDateTime createdAt;

	private LocalDateTime updateTime;
}
