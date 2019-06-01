package com.xilidou.do4j.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Zhengxin
 */
@Data
@ToString
@ApiModel
public class BaseTimeVo {

	private Long expectDuration;

	private LocalDateTime delayToTime;

	private LocalDateTime upToTime;

	private LocalDateTime finishedTime;

	private Boolean canRepeat;

	private Integer intervalValue;

	private String  intervalUnit;

	private List<Integer> daysOfMonth;

	private List<Integer> daysOfWeek;

	private Integer reviewInterval;

	private Integer reviewIntervalUnit;

	private LocalDateTime noticeDetail;



}
