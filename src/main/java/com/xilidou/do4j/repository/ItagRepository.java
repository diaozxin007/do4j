package com.xilidou.do4j.repository;

import com.xilidou.do4j.entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Zhengxin
 */
public interface ItagRepository extends JpaRepository<TagEntity,Long> {

	List<TagEntity> getAllByIdIn(List<Long> ids);

}
