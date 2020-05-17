package com.app.demo.thread.example;

/**
 * @ProjectName: breeze
 * @PackageName: com.app.demo.thread.example
 * @ClassName: TestSynchronized
 * @Description:
 * @author: wangjie
 * @date: 2020/5/16  10:28
 * @Copyright: 趣医网络技术服务有限公司 版权所有 Copyright (c) 2020
 */

public class TestNoSynchronized {

    public  void minus() {
        int count = 5;
        for (int i = 0; i < 5; i++) {
            count--;
            System.out.println(Thread.currentThread().getName() + " - " + count);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
        }
    }

    public  void minus2() {
        int count = 5;
        for (int i = 0; i < 5; i++) {
            count--;
            System.out.println(Thread.currentThread().getName() + " - " + count);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
        }
    }

}