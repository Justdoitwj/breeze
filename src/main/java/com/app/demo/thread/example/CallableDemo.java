package com.app.demo.thread.example;

import com.app.breeze.utils.date.DateUtil;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * @ProjectName: breeze
 * @PackageName: com.app.demo.thread.example
 * @ClassName: CallableDemo
 * @Description:
 * @author: wangjie
 * @date: 2019/12/27  22:19
 * @Copyright: 趣医网络技术服务有限公司 版权所有 Copyright (c) 2019
 */
@Slf4j
public class CallableDemo {
    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 100;
    private static final Long KEEP_ALIVE_TIME = 1L;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        testCallable1();
//        testCallableSubmit();
//        testCallableSubmit1();
//        testCallableSubmit2();
//        testRunnableSubmit3();
        testThreadCatchException();
    }


    /**
     * @throws InterruptedException
     * @throws ExecutionException
     */
    public static void testCallable1() throws InterruptedException, ExecutionException {
        //使用阿里巴巴推荐的创建线程池的方式
        //通过ThreadPoolExecutor构造函数自定义参数创建
        ThreadPoolExecutor executor = getThreadPoolExecutor();
        List<Future<String>> futureList = new ArrayList<>();
        Callable<String> callable = new MyCallable();
        for (
                int i = 0;
                i < 100; i++) {
            //提交任务到线程池
            Future<String> future = executor.submit(callable);
            //将返回值 future 添加到 list，我们可以通过 future 获得 执行 Callable 得到的返回值
            futureList.add(future);
        }
        for (
                Future<String> fut : futureList) {
            try {
                /**
                 * fut.get()
                 * get()方法的阻塞性
                 * 通过上面的输出可以看到，在调用submit提交任务之后，主线程本来是继续运行了。但是运行到future.get()的时候就阻塞住了，一直等到任务执行完毕，拿到了返回的返回值，主线程才会继续运行。
                 *
                 * 这里注意一下，他的阻塞性是因为调用get()方法时，任务还没有执行完，所以会一直等到任务完成，形成了阻塞。
                 *
                 * 任务是在调用submit方法时就开始执行了，如果在调用get()方法时，任务已经执行完毕，那么就不会造成阻塞。
                 */
                log.info(new Date() + "::" + fut.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        log.info("线程池线程活跃线程数：" + executor.getActiveCount());
        while (executor.getActiveCount() != 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        isTerminated 当调用 shutdown() 方法后，并且所有提交的任务完成后返回为 true
        //关闭线程池
        executor.shutdown();
    }

    /**
     *
     */
    public static void testCallableSubmit() throws InterruptedException, ExecutionException {
        ThreadPoolExecutor executor = getThreadPoolExecutor();
        //创建一个Callable，3秒后返回String类型
        Callable myCallable = new Callable() {
            @Override
            public String call() throws Exception {
                Thread.sleep(3000);
                System.out.println("calld方法执行了");
                return "call方法返回值";
            }
        };
        System.out.println("提交任务之前 " + DateUtil.getDateTime());
        Future future = executor.submit(myCallable);
        System.out.println("提交任务之后，获取结果之前 " + DateUtil.getDateTime());
        /**
         * future.get()
         * get()方法的阻塞性
         * 通过上面的输出可以看到，在调用submit提交任务之后，主线程本来是继续运行了。但是运行到future.get()的时候就阻塞住了，一直等到任务执行完毕，拿到了返回的返回值，主线程才会继续运行。
         *
         * 这里注意一下，他的阻塞性是因为调用get()方法时，任务还没有执行完，所以会一直等到任务完成，形成了阻塞。
         *
         * 任务是在调用submit方法时就开始执行了，如果在调用get()方法时，任务已经执行完毕，那么就不会造成阻塞。
         */
        System.out.println("获取返回值: " + future.get());
        System.out.println("获取到结果之后 " + DateUtil.getDateTime());
    }

    /**
     * 进一步验证Future.get()的阻塞性
     *
     * @throws InterruptedException
     * @throws ExecutionException
     */
    public static void testCallableSubmit1() throws InterruptedException, ExecutionException {
        ThreadPoolExecutor executor = getThreadPoolExecutor();
        //创建一个Callable，3秒后返回String类型
        Callable myCallable = new Callable() {
            @Override
            public String call() throws Exception {
                Thread.sleep(3000);
                System.out.println("calld方法执行了");
                return "call方法返回值";
            }
        };
        System.out.println("提交任务之前 " + getStringDate());
        Future future = executor.submit(myCallable);
        System.out.println("提交任务之后 " + getStringDate());
        Thread.sleep(4000);
        //因为睡了4秒，任务已经执行完毕，所以get方法立马就得到了结果。
        System.out.println("已经睡了4秒,开始获取结果 " + getStringDate());
        System.out.println("获取返回值: " + future.get());
        System.out.println("获取到结果之后 " + getStringDate());
    }

    /**
     * 验证Future.get()的阻塞性
     * 如果submit两个任务时，总阻塞时间是最长的那个。
     *
     * @throws InterruptedException
     * @throws ExecutionException
     */
    public static void testCallableSubmit2() throws InterruptedException, ExecutionException {
        ThreadPoolExecutor executor = getThreadPoolExecutor();
        Callable myCallable = new Callable() {
            @Override
            public String call() throws Exception {
                Thread.sleep(5000);
                System.out.println("calld方法执行了");
                return "call 5秒的方法返回值";
            }
        };
        Callable myCallable2 = new Callable() {
            @Override
            public String call() throws Exception {
                Thread.sleep(3000);
                System.out.println("calld2方法执行了");
                return "call 3秒方法返回值";
            }
        };
        System.out.println("提交任务之前 " + getStringDate());
        Future future = executor.submit(myCallable);
        Future future2 = executor.submit(myCallable2);
        System.out.println("提交任务之后 " + getStringDate());
        System.out.println("开始获取第一个返回值 " + getStringDate());
        System.out.println("获取返回值: " + future.get());
        System.out.println("获取第一个返回值结束，开始获取第二个返回值 " + getStringDate());
        System.out.println("获取返回值2: " + future2.get());
        System.out.println("获取第二个返回值结束 " + getStringDate());

    }

    /**
     * submit(Runnable task, T result)
     * 虽然submit传入Runnable不能直接返回内容，但是可以通过submit(Runnable task, T result)传入一个载体，
     * 通过这个载体获取返回值。这个其实不能算返回值了，是交给线程处理一下。
     *
     * @throws InterruptedException
     * @throws ExecutionException
     */
    public static void testRunnableSubmit3() throws InterruptedException, ExecutionException {
        ThreadPoolExecutor executor = getThreadPoolExecutor();
        TestData data = new TestData();
        Future<TestData> future = executor.submit(new MyRunnableTestData(data), data);
        System.out.println("返回的结果 name: " + future.get().getName() + ", sex: " + future.get().getSex());
        System.out.println("原来的Data name: " + data.getName() + ", sex: " + data.getSex());
        log.info("发现原来的data值也变了,引用变量");
    }

    /**
     * 异常
     * 使用submit方法还有一个特点就是，他的异常可以在主线程中catch到。
     * 而使用execute方法执行任务是捕捉不到异常的。
     *
     * @throws InterruptedException
     * @throws ExecutionException
     */
    public static void testThreadCatchException() throws InterruptedException, ExecutionException {
        ThreadPoolExecutor executor = getThreadPoolExecutor();
        //并没有出现抓到异常哪行日志。而且这个异常输出是在线程pool-1-thread-1中，
        // 并不是在主线程中。说明主线程的catch不能捕捉到这个异常。
        Runnable myRunnable = new Runnable() {
            @Override
            public void run() {
                executor.execute(null);
            }
        };
        try {
            executor.execute(myRunnable);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("myRunnable抓到异常 " + e.getMessage());
        }
        System.out.println("##########################################");
        //Callable 主线程能够捕捉到子线程的异常信息
        Callable myCallable=new Callable() {
            @Override
            public Object call() throws Exception {
                executor.execute(null);
                return  Thread.currentThread().getName();
            }
        };
        try {
            Future future1 = executor.submit(myCallable);
            future1.get();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("myCallable抓到异常 " + e.getMessage());
        }
    }

    /**
     * 创建线程池
     *
     * @return
     */
    private static ThreadPoolExecutor getThreadPoolExecutor() {
        //使用阿里巴巴推荐的创建线程池的方式
        //通过ThreadPoolExecutor构造函数自定义参数创建
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy());
        return executor;
    }

    public static String getStringDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        String dateString = formatter.format(currentTime);
        return dateString;
    }
}

