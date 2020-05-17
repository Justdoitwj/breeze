package com.app.demo.thread.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

/**
 * @ProjectName: breeze
 * @PackageName: com.app.demo.thread.example
 * @ClassName: AccumulatorDemo
 * @Description:
 * @author: wangjie
 * @date: 2020/5/4  11:49
 * @Copyright: 趣医网络技术服务有限公司 版权所有 Copyright (c) 2020
 */

public class AtomicDemo {
    private static ExecutorService cachedThreadPool;

    //从初始值0开始，做加/减处理，每次加/减1
    private static LongAdder adder = new LongAdder();

    //从初始值0开始，做累加处理
    private static LongAccumulator accumulator1 = new LongAccumulator((x, y) -> x+y, 0);

    //从初始值1开始，做累积处理
    private static LongAccumulator accumulator2 = new LongAccumulator((x, y) -> x*y, 1);
    public static void main(String[] args) {
        sharedvariablesTest();
    }

    /**
     * 线程池中共享变量的定义和使用
     */
    private static void sharedvariablesTest(){
        cachedThreadPool = Executors.newCachedThreadPool();

        for(int i=0; i<10; i++){
            cachedThreadPool.submit(() -> {
                adder.increment(); //加1
//              adder.decrement(); //减1
                System.out.println(adder.intValue());

                accumulator1.accumulate(2); //每次加2
                System.out.println(accumulator1.get()); //获取当前值

                accumulator2.accumulate(2); //每次 * 2
                System.out.println(accumulator2.get()); //获取当前值

            });
        }
        cachedThreadPool.shutdown();
    }

    private static void sharedvariablesTest1(){
        LongAdder adder = new LongAdder();
        adder.add(2);
        System.out.println(adder.intValue());   // 输出 2

        adder.increment();
        System.out.println(adder.sum());  // 输出 3  sum方法返回long型

        // 同 accumulateAndGet 方法, 将原子值和传入的参数组合
        LongAccumulator la = new LongAccumulator((left, right) -> left + right, 10);
        System.out.println(la.intValue());  // 输出 10
        la.accumulate(1);
        System.out.println(la.intValue());  // 输出 11

        AtomicInteger ai = new AtomicInteger();

        // 多线程环境下安全更新
        Integer i = ai.updateAndGet(x -> 5);
        System.out.println(i);   // 输出 5

        // 多线程环境下安全更新  将原子值和传入的参数组合
        ai.accumulateAndGet(1, (oldValue, paramValue) -> oldValue + paramValue);
        System.out.println(ai.get());   // 输出 6
    }
}
