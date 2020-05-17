package com.app.demo.enums;

import lombok.extern.slf4j.Slf4j;

import java.util.Set;

/**
 * @ProjectName: breeze
 * @PackageName: com.app.demo.enums
 * @ClassName: EnumSetDemo
 * @Description:
 * @author: wangjie
 * @date: 2020/1/5  17:46
 * @Copyright: 趣医网络技术服务有限公司 版权所有 Copyright (c) 2020
 */
@Slf4j
public class EnumSetDemo {
    /**
     *
     */
    public enum Style{
        BLOD,ITALIC,UNDERLIN;
    }
    public void applyStyle(Set<Style> styleSet){
        for(Style style:styleSet){
            log.info(style.name());
        }
    }
}
