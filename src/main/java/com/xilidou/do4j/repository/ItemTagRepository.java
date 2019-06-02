package com.xilidou.do4j.repository;

import com.xilidou.do4j.entity.ItemTagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemTagRepository extends JpaRepository<ItemTagEntity,Long> {

	void deleteByItemIdIn(List<Long> ids);

	List<ItemTagEntity> findAllByItemId(long itemId);
}
