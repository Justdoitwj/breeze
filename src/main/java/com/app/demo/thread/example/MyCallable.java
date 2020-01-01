package com.app.demo.thread.example;

import java.util.concurrent.Callable;

/**
 * @ProjectName: breeze
 * @PackageName: com.app.demo.thread.example
 * @ClassName: MyCallable
 * @Description:
 * @author: wangjie
 * @date: 2019/12/27  22:18
 * @Copyright: 趣医网络技术服务有限公司 版权所有 Copyright (c) 2019
 */

public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        //返回执行当前 Callable 的线程名字
        return Thread.currentThread().getName();
    }
}
