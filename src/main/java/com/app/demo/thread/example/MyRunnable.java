package com.app.demo.thread.example;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * @ProjectName: breeze
 * @PackageName: com.app.demo.thread.example
 * @ClassName: MyRunnable
 * @Description:
 * @author: wangjie
 * @date: 2019/12/27  21:22
 * @Copyright: 趣医网络技术服务有限公司 版权所有 Copyright (c) 2019
 *
 * 因为Runnable是没有返回值的，所以如果submit一个Runnable的话，get得到的为null：
 */
@Slf4j
public class MyRunnable implements Runnable  {
    private String command;

    public MyRunnable(String s) {
        this.command = s;
    }

    @Override
    public void run() {
        log.error(Thread.currentThread().getName() + " Start. Time = " + new Date());
        processCommand();
        log.error(Thread.currentThread().getName() + " End. Time = " + new Date());
    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.command;
    }
}
