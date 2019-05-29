package com.xilidou.do4j.entity;

import cn.leancloud.AVObject;
import cn.leancloud.annotation.AVClassName;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

/**
 * item实体
 */
@Data
@ToString
@AVClassName("item")
public class ItemEntity extends AVObject {

	private long id;

	/**
	 * 标题
	 */
	private String title;

	/**
	 * 状态
	 */
	private int status;

	/**
	 * 是否已标注
	 */
	private boolean marked;

	/**
	 * 类型(仅项目层级)
	 */
	private String type;

	/**
	 * 父级item的id
	 */
	private long parentId;

	/**
	 * 层级路径 ex: 1.2.3.
	 */
	private String levelPath;

	/**
	 * 在层级中的顺序
	 */
	private int seq;

	/**
	 * 预计持续时间(不是具体时间点，是一个时间段，比如3分钟)，单位为 分钟，最小支持到1分钟，小于1分钟归为1分钟
	 */
	private long expectDuration;

	/**
	 * 推迟至
	 */
	private LocalDateTime delayToTime;

	/**
	 * 截止时间
	 */
	private LocalDateTime upToTime;

	/**
	 * 已完成时间
	 */
	private LocalDateTime finishedTime;

	/**
	 * 是否重复
	 */
	private int canRepeat;

	/**
	 * 重复时间单位
	 */
	private String intervalUnit;

	/**
	 * 重复时间数值，仅支持整数。ex: 当intervalUnit选择天，则 1 代表 1天，不支持1.5天
	 */
	private int intervalValue;

	/**
	 * 重复设置扩展字段。 可分为以下几种情况：<br>
	 *
	 * <p>选择周: ext是周中的一天或几天。ex:[1,3,5] 表示周中的周一、周三、周五；<br>
	 * <p>选择月: ext可选择 <br>
	 * 		1.月中的一天：[2,5,12,31] 表示月中的2号、5号、12号、31号 <br>
	 * 		2.周中的一天：json形式 <br>
	 *      {
	 * 		  "weekOfMonth" : "1",  //月中的第一周
	 * 		  "daysOfWeek" : [1,2,3,4,5] //第一周的工作日
	 * 		}
	 */
	private String intervalExt;

	/**
	 * 重复条件
	 *
	 * 可选值：
	 * 1 : 完成
	 * 2 : 已分配日期
	 */
	private int intervalCondition;

	/**
	 * 通知详情
	 *
	 * 一个包含n个时间点的List，标识通知的时间列表
	 */
	private List<LocalDateTime> noticeDetail;

	/**
	 * 检查间隔(仅项目)
	 *
	 * 以json格式存储：
	 * {
	 *     "unit" : "day",  //单位是天
	 *     "value": 2       //2天
	 * }
	 */
	private String reviewInterval;

	/**
	 * 附注
	 */
	private String note;

	/**
	 * 用户id
	 */
	private long userId;

	/**
	 * 创建时间
	 */
	private LocalDateTime createAt;

	/**
	 * 更新时间
	 */
	private LocalDateTime updateAt;
}
