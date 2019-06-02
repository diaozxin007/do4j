package com.xilidou.do4j.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author Zhengxin
 */
@Data
@ToString
@Entity
@Table(name = "tag")
@EntityListeners(AuditingEntityListener.class)
public class TagEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;

	private Integer status;

	private Long userId;

	@CreatedDate
	private LocalDateTime createAt;

	@LastModifiedDate
	private LocalDateTime updateAt;
}
