package com.xilidou.do4j.repository;

import com.xilidou.do4j.entity.SettingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: renmagical
 * @Date: 2019-06-01 21:12
 * @Description: 设置信息repository
 */
public interface SettingRepository extends JpaRepository<SettingEntity,Long> {

    SettingEntity getByUserId(long userId);

}
