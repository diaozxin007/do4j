package com.xilidou.do4j.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@ToString
@Entity
@Table(name = "tag")
public class TagEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;

	private Integer status;

	private Long userId;

	private LocalDateTime createAt;

	private LocalDateTime updateAt;
}
