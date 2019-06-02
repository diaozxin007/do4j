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
@ApiModel
public class BaseTimeVo {

	private Long expectDuration;

	@JsonFormat(pattern = "YYYY-MM-DD HH:mm:ss")
	private LocalDateTime delayToTime;

	private LocalDateTime upToTime;

	private LocalDateTime finishedTime;

	private Boolean canRepeat;

	private Integer intervalValue;

	private Integer  intervalUnit;

	private List<Integer> weekOfMonth;

	private List<Integer> daysOfWeek;

	private Integer reviewIntervalValue;

	private Integer reviewIntervalUnit;

	private List<LocalDateTime> noticeTimes;



}
