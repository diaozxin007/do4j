package com.xilidou.do4j.repository;

import com.xilidou.do4j.entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: renmagical
 * @Date: 2019-06-01 22:42
 * @Description:
 */
public interface TagRepository extends JpaRepository<TagEntity,Long> {

    List<TagEntity> findByUserId(long userId);

    List<TagEntity> findByUserIdAndStatus(long userId,int status);
}
