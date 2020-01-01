package com.app.demo.thread.example;

/**
 * @ProjectName: breeze
 * @PackageName: com.app.demo.thread.example
 * @ClassName: MyRunnableTestData
 * @Description:
 * @author: wangjie
 * @date: 2019/12/29  21:29
 * @Copyright: 趣医网络技术服务有限公司 版权所有 Copyright (c) 2019
 */

public class MyRunnableTestData implements Runnable {
    TestData data;

    public MyRunnableTestData(TestData name) {
        this.data = name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            System.out.println("线程 执行:");
            data.setName("新名字");
            data.setSex("新性别");
    } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
