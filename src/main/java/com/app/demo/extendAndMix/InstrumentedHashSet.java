package com.app.demo.extendAndMix;

import java.util.*;

/**
 * @ProjectName: breeze
 * @PackageName: com.app.demo.extendAndMix
 * @ClassName: InstrumentedHashSet
 * @Description:
 * @author: wangjie
 * @date: 2020/1/5  18:35
 * @Copyright: 趣医网络技术服务有限公司 版权所有 Copyright (c) 2020
 */

public class InstrumentedHashSet<E> extends HashSet<E> {

    private int addCount=0;

    public InstrumentedHashSet(){}

    public InstrumentedHashSet(int initCap,float loadFactor){
        super(initCap,loadFactor);
    }
    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount+=c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }
}
