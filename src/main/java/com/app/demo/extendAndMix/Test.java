package com.app.demo.extendAndMix;

import java.util.*;

/**
 * @ProjectName: breeze
 * @PackageName: com.app.demo.extendAndMix
 * @ClassName: Test
 * @Description: 装饰者模式+适配器模式？？？
 * @author: wangjie
 * @date: 2020/1/5  18:34
 * @Copyright: 趣医网络技术服务有限公司 版权所有 Copyright (c) 2020
 */

public class Test {
    public static void main(String[] args) {
        /**
         * 方案一：使用继承来拓展现有的类
         * 缺点：当被继承的类有改动的时候子类有可能受到破坏。
         */
        InstrumentedHashSet<String> instrumentedHashSet=new InstrumentedHashSet();
        instrumentedHashSet.addAll(Arrays.asList("aa","bb","cc"));
        System.out.println(instrumentedHashSet.getAddCount()+"");
        /**
         * 方案二：采用复合
         * 定义：不用扩展现有的类，而是在新的类中增加一个私有域，它引用现有类的一个实例。
         * 这种设计被称作“复合”。
         * 因为现有的类变成了新的一个组件，新类中每个实例方法都可以调用被包含的现有类实力中对应的方法，并返回结果
         * 这被称作转发，在新类中的方法被称为转发方法。
         * 优点：这样的类将会非常稳固，它不依赖于现有类的实现细节，即使现有类添加了新的方法，也不会影响新的类。
         *
         */

        InstrumentedHashSetPlus hashSetPlus=new InstrumentedHashSetPlus(new HashSet<Date>());
        hashSetPlus.add(new Date());
        Set<String> stree=new TreeSet<String>(Arrays.asList("11","22","33"));
        InstrumentedHashSetPlus s2=new InstrumentedHashSetPlus(new TreeSet());
        s2.addAll(stree);
        System.out.println(hashSetPlus.getAddCount()+"");
        System.out.printf(s2.getAddCount()+"");
    }
}
