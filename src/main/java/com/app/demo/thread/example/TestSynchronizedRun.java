package com.app.demo.thread.example;

/**
 * @Description
 * 两个线程 thread1 和 thread2，同时访问对象的方法，由于该方法是 synchronized 关键字修饰的，那么这两个线程
 * 都需要获得该对象锁，一个获得后另一个线程必须等待。所以我们可以猜测运行结果应该是，一个线程执行完毕后，另一个
 * 线程才开始执行，运行例子，输出打印结果如下：
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
 * ————————————————
 * @Author wangjie
 * @Param
 * @Return
 * @throws:
 * @Date 2020/5/16 10:29
 */
public class TestSynchronizedRun {
    public static void main(String[] args) {
        final TestSynchronized test = new TestSynchronized();

        Thread thread1 = new Thread(new Runnable() {

            @Override
            public void run() {
                test.minus();
            }
        });

        Thread thread2 = new Thread(new Runnable() {

            @Override
            public void run() {
                test.minus();
            }
        });

        thread1.start();
        thread2.start();

    }
}
