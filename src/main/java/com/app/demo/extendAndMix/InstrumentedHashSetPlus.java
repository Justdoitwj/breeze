package com.app.demo.extendAndMix;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @ProjectName: breeze
 * @PackageName: com.app.demo.extendAndMix
 * @ClassName: InstrumentedHashSet
 * @Description:
 * @author: wangjie
 * @date: 2020/1/5  18:35
 * @Copyright: 趣医网络技术服务有限公司 版权所有 Copyright (c) 2020
 */

public class InstrumentedHashSetPlus<E> extends ForwardingSet<E> {

    public InstrumentedHashSetPlus(Set<E> s) {
        super(s);
    }

    private int addCount=0;

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount+=c.size();
        return super.addAll(c);
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    public int getAddCount() {
        return addCount;
    }
}
