package com.xilidou.do4j.service;

import com.xilidou.do4j.entity.SettingEntity;
import com.xilidou.do4j.repository.SettingRepository;
import com.xilidou.do4j.vo.SettingVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: renmagical
 * @Date: 2019-06-01 21:20
 * @Description:
 */
@Service
public class SettingService {

    @Autowired
    private SettingRepository settingRepository;

    /**
     * 根据userId获取设置信息(userId是唯一键，所以只会返回一条数据)
     * @param userId
     * @return
     */
    public SettingEntity getByUserId(long userId){
        return settingRepository.getByUserId(userId);
    }

    /**
     * 保存用户设置信息
     * 该方法包含了添加和更新逻辑，统称为save
     * @param settingVo
     */
    public SettingEntity save(SettingVo settingVo){
        SettingEntity settingEntity = voToEntity(settingVo);
        // 先根据userId查询库中是否已经存在，若存在则进行更新，否则添加
        SettingEntity existEntity = getByUserId(settingEntity.getUserId());
        if (existEntity != null && existEntity.getId() > 0){
            settingEntity = existEntity;
        }
        return settingRepository.save(settingEntity);
    }

    private SettingEntity voToEntity(SettingVo vo){
        SettingEntity settingEntity = new SettingEntity();
        BeanUtils.copyProperties(vo,settingEntity);
        return settingEntity;
    }


}
