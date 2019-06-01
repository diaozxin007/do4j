package com.xilidou.do4j.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @Author: renmagical
 * @Date: 2019-06-01 21:09
 * @Description:
 */
@Data
@ToString
@Table(name = "setting")
@Entity
public class SettingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long userId;

    private String content;

    private LocalDateTime createAt;

    private LocalDateTime updateAt;
}
