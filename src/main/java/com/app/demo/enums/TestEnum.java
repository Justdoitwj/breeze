package com.app.demo.enums;

import lombok.extern.slf4j.Slf4j;

import java.util.EnumSet;

/**
 * @ProjectName: breeze
 * @PackageName: com.app.demo.enums
 * @ClassName: TestEnum
 * @Description:
 * @author: wangjie
 * @date: 2020/1/5  15:54
 * @Copyright: 趣医网络技术服务有限公司 版权所有 Copyright (c) 2020
 */
@Slf4j
public class TestEnum {
    public static void main(String[] args){
        log.info(EnumDemo.Friday.toString());
        log.info(EnumDemo.Monday.ordinal()+"");//所有的枚举都有一个ordinal方法，返回枚举常量在类型中国的数字位置
        double x=1,y=3;
        for(Opertion op :Opertion.values()){
            System.out.printf("%f %s %f=%f%n",x,op,y,op.apply(x,y));
        }

        log.info("支付钱数："+PayrollDay.FRIDAY.pay(10,50));

        //
        EnumSetDemo enumSetDemo=new EnumSetDemo();
        enumSetDemo.applyStyle(EnumSet.of(EnumSetDemo.Style.BLOD,EnumSetDemo.Style.ITALIC));
    }
}
