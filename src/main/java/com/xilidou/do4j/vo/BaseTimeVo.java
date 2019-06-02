package com.xilidou.do4j.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Zhengxin
 */
@Data
@ToString
@ApiModel(description = "基础时间对象")
public class BaseTimeVo {

	private Long expectDuration;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime delayToTime;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime upToTime;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime finishedTime;

	private Boolean canRepeat;

	private Integer intervalValue;

	private Integer  intervalUnit;

	private List<Integer> weekOfMonth;

	private List<Integer> daysOfWeek;

	private Integer reviewIntervalValue;

	private Integer reviewIntervalUnit;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private List<LocalDateTime> noticeTimes;



}
