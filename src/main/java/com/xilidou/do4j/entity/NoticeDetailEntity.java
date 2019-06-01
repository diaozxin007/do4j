package com.xilidou.do4j.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@ToString
@Entity
@Table(name = "notice_detail")
public class NoticeDetailEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long itemId;

	private Integer status;

	private LocalDateTime createAt;

	private LocalDateTime updateAt;

}
