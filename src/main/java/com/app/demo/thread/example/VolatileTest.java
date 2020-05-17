package com.app.demo.thread.example;

/**
 * @ProjectName: breeze
 * @PackageName: com.app.demo.thread.example
 * @ClassName: VolatileTest
 * @Description:
 * @author: wangjie
 * @date: 2020/5/4  15:17
 * @Copyright: 趣医网络技术服务有限公司 版权所有 Copyright (c) 2020
 */

public class VolatileTest extends Thread{

//    volatile  boolean ready = false;
    boolean ready = false;
    int i = 0;
    @Override
    public void run() {
        while (!ready) {
             i++;
//             System.out.println(i++);
//             System.out.println("run ready:"+ready);
        }
    }

    public static void main(String[] args) throws Exception {
        VolatileTest vt = new VolatileTest();
        vt.start();
        Thread.sleep(1000);
        vt.ready = true;
        System.out.println("stope1：" + vt.i);
        System.out.println("stope1：" + vt.ready);
        Thread.sleep(1000);
        System.out.println("stope2：" + vt.i);
        System.out.println("stope1：" + vt.ready);
    }
}
