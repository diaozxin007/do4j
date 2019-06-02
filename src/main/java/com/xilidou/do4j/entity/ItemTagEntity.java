package com.xilidou.do4j.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@ToString
@Table(name = "item_tag")
@Entity
@EntityListeners(AuditingEntityListener.class)
public class ItemTagEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long tagId;

	private Long itemId;

	@CreatedDate
	private LocalDateTime createAt;

	@LastModifiedDate
	private LocalDateTime updateAt;
}
