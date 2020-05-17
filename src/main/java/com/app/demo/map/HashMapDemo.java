package com.app.demo.map;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @ProjectName: breeze
 * @PackageName: com.app.demo.map
 * @ClassName: HashMapDemo
 * @Description:
 * @author: wangjie
 * @date: 2020/5/14  11:30
 * @Copyright: 趣医网络技术服务有限公司 版权所有 Copyright (c) 2020
 */

public class HashMapDemo {

    public static void main(String[] args) {
        ConcurrentMap concurrentMap=new ConcurrentHashMap();
        Map map= Maps.newConcurrentMap();
        map.put("","");
    }
}
