package com.xilidou.do4j.service;

import com.xilidou.do4j.entity.SettingEntity;
import com.xilidou.do4j.repository.SettingRepository;
import com.xilidou.do4j.utils.JsonUtils;
import com.xilidou.do4j.vo.SettingContentVo;
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
     * @return 设置信息
     */
    public SettingVo getByUserId(long userId){
        SettingVo settingVo = new SettingVo();
        SettingEntity settingEntity = settingRepository.getByUserId(userId);
        if (settingEntity != null){
            settingVo = entityToVo(settingEntity);
        }
        return settingVo;
    }

    /**
     * 保存用户设置信息
     * 该方法包含了添加和更新逻辑，统称为save
     * @param settingVo
     * @return 设置的id
     */
    public long save(SettingVo settingVo){
        SettingEntity settingEntity = voToEntity(settingVo);
        // 先根据userId查询库中是否已经存在，若存在则进行更新，否则添加
        SettingVo existVo = getByUserId(settingEntity.getUserId());
        if (existVo != null && existVo.getId() > 0){
            settingEntity.setId(existVo.getId());
        }
        settingEntity = settingRepository.save(settingEntity);
        return settingEntity.getId();
    }

    private SettingEntity voToEntity(SettingVo vo){
        SettingEntity settingEntity = new SettingEntity();
        BeanUtils.copyProperties(vo,settingEntity);
        //处理content内容，对象 -> json串
        settingEntity.setContent(JsonUtils.write(vo.getContent()));
        return settingEntity;
    }

    private SettingVo entityToVo(SettingEntity entity){
        SettingVo settingVo = new SettingVo();
        BeanUtils.copyProperties(entity,settingVo);
        settingVo.setContent(JsonUtils.read(entity.getContent(), SettingContentVo.class));
        return settingVo;
    }

}
