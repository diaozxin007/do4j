package com.xilidou.do4j.vo;

import com.xilidou.do4j.constants.Const;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * 设置内容对象
 */
@Data
@ToString
@ApiModel
public class SettingContentVo {

    /**
     * 整理包含以下内容的收件箱项
     */
    private Const.ClearUpToInboxTypeEnum clearUpToInboxInclude;

    /**
     * 即将截止日期
     */
    private Const.DeadlineTypeEnum deadLineType;

    /**
     * 推迟日期的预期时间
     */
    private LocalDateTime predictForDelay;

    /**
     * 截止日期的预设时间
     */
    private LocalDateTime preidictForDeadline;
}
