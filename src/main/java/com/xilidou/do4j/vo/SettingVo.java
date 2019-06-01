package com.xilidou.do4j.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @Author: renmagical
 * @Date: 2019-06-01 21:26
 * @Description:
 */
@Data
@ToString
@ApiModel
public class SettingVo {

    private long id;

    private long userId;

    //todo 写成对象的形式，在数据层存储时再转成字符串
    private String content;

    private LocalDateTime createAt;

    private LocalDateTime updateAt;
}
