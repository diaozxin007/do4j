package com.xilidou.do4j.controller;

import com.xilidou.do4j.entity.SettingEntity;
import com.xilidou.do4j.service.SettingService;
import com.xilidou.do4j.vo.SettingVo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: renmagical
 * @Date: 2019-06-01 23:31
 * @Description: 用户设置Controller
 */
@RestController
@RequestMapping("/setting")
public class SettingController {

    @Autowired
    private SettingService settingService;

    @GetMapping("/{userId}")
    @ApiOperation(value = "获取用户设置信息")
    public SettingVo getUserSetting(@ApiParam(value = "用户id",required = true) @PathVariable("userId") long userId){
        SettingEntity byUserId = settingService.getByUserId(userId);
        SettingVo settingVo = new SettingVo();
        if (byUserId != null){
            BeanUtils.copyProperties(byUserId,settingVo);
        }
        return settingVo;
    }

    @PostMapping
    @ApiOperation(value = "保存用户设置信息")
    public SettingEntity saveUserSetting(@ApiParam(value = "设置信息") @RequestBody SettingVo settingVo){
        return settingService.save(settingVo);
    }
}
