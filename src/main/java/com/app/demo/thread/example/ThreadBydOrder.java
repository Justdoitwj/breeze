package com.app.demo.thread.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ProjectName: breeze
 * @PackageName: com.app.demo.thread.example
 * @ClassName: ThreadBydOrder
 * @Description:
 * @author: wangjie
 * @date: 2020/5/16  11:05
 * @Copyright: 趣医网络技术服务有限公司 版权所有 Copyright (c) 2020
 */

public class ThreadBydOrder {
    public static void main(String[] args) {
        final Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " run 1");
            }
        }, "T1");
        final Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " run 2");
                try {
                    t1.join(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "T2");
        final Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " run 3");
                try {
                    t2.join(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "T3");

        ExecutorService single= Executors.newSingleThreadExecutor();
        single.submit(t1);
        single.submit(t2);
        single.submit(t3);
        single.shutdown();
    }
}
