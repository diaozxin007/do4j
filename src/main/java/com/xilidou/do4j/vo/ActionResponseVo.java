package com.xilidou.do4j.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
public class ActionResponseVo {

	private String id;

	private String title;

	private int status;

	private Boolean marked;

	private String type;

	private Long parentId;

	private String path;

	private Integer seq;

	private BaseTimeVo timeVo;

	private String note;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime createAt;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime updateAt;


}
