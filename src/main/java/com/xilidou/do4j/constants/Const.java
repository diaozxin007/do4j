package com.xilidou.do4j.constants;

import lombok.Data;

/**
 * @Author: renmagical
 * @Date: 2019-06-01 23:13
 * @Description: 公共常量
 */
public class Const {

    /**
     * 统一状态
     */
    public class Status{
        public static final int ACTIVE = 0;
        public static final int DELETED = 1;
        public static final int PASUD = 2;
        public static final int FININSHED = 3;
    }

    public enum ItemType{

        Action("action","活动"),
        Project("prjoct","项目");

        public String type;
        public String name;

        ItemType(String type,String name){
            this.type = type;
            this.name = name;
        }
    }

    /**
     * 设置中的 整理包含以下内容的到收件箱项 的类型
     */
    public enum ClearUpToInboxTypeEnum{

        Project(0,"项目"),
        Label(1,"标签"),
        ProjectOrLabel(2,"项目或标签"),
        ProjectAndLabel(3,"项目和标签");


        private int value;
        private String name;

        ClearUpToInboxTypeEnum(int value, String name) {
            this.value = value;
            this.name = name;
        }
    }

    /**
     * 设置中的 即将截止日期类型
     */
    public enum DeadlineTypeEnum{

        Today(0,"今天"),
        _24Hours(1,"24小时"),
        TwoDays(2,"2天"),
        ThreeDays(3,"3天"),
        FourDays(4,"4天"),
        FiveDays(5,"5天"),
        OneWeek(6,"1周");

        private int value;
        private String name;

        DeadlineTypeEnum(int value, String name) {
            this.value = value;
            this.name = name;
        }
    }
}
