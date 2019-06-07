package com.xilidou.do4j.repository;

import com.xilidou.do4j.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Zhengxin
 */
public interface ItemRepository extends JpaRepository<ItemEntity,Long> {

	List<ItemEntity> findAllByTypeAndStatusIn(String type,List<Integer> status);

}
