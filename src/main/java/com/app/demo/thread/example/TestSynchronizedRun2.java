package com.app.demo.thread.example;

/**
 * @Description
 * Thread-0 - 4
 * Thread-0 - 3
 * Thread-0 - 2
 * Thread-0 - 1
 * Thread-0 - 0
 * Thread-1 - 4
 * Thread-1 - 3
 * Thread-1 - 2
 * Thread-1 - 1
 * Thread-1 - 0
 * 可以看到，某个线程得到了对象锁之后，该对象的其他同步方法是锁定的，其他线程是无法访问的。
 * ————————————————
 * @Author wangjie
 * @Param
 * @Return
 * @throws:
 * @Date 2020/5/16 10:29
 */
public class TestSynchronizedRun2 {
    public static void main(String[] args) {
        final TestSynchronized2 test = new TestSynchronized2();
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
