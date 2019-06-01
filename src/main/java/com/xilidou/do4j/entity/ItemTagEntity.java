package com.xilidou.do4j.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@ToString
@Table(name = "item_tag")
@Entity
public class ItemTagEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long tagId;

	private Long itemId;

	private LocalDateTime createAt;

	private LocalDateTime updateAt;
}
