package com.app.demo.thread.example;

/**
 * @Description
 * @Author wangjie
 * @Param
 * @Return
 * @throws:
 * @Date 2020/5/16 10:29
 */
public class TestNoSynchronizedRun {
    public static void main(String[] args) {
        final TestNoSynchronized test = new TestNoSynchronized();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                test.minus();
            }
        });

        Thread thread2 = new Thread(new Runnable() {

            @Override
            public void run() {
                test.minus2();
            }
        });

        thread1.start();
        thread2.start();
    }
}
