package com.xilidou.do4j.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author Zhengxin
 */
@Entity
@Table(name = "review")
@Data
@ToString
public class ReviewEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long itemId;

	private Long userId;

	private LocalDateTime nextReviewTime;

	private LocalDateTime createdAt;

	private LocalDateTime updateAt;

}
