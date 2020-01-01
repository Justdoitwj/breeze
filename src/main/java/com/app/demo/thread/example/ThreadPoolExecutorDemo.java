package com.app.demo.thread.example;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @ProjectName: breeze
 * @PackageName: com.app.demo.thread.example
 * @ClassName: ThreadPoolExecutorDemo
 * @Description:
 * @author: wangjie
 * @date: 2019/12/27  16:46
 * @Copyright: 趣医网络技术服务有限公司 版权所有 Copyright (c) 2019
 */
@Slf4j
public class ThreadPoolExecutorDemo {
    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 100;
    private static final Long KEEP_ALIVE_TIME = 1L;
    public static void   main(String[] args){
        //多线程
        ExecutorService executorFixed = Executors.newFixedThreadPool(5);
//        public long getTaskCount() //线程池已执行与未执行的任务总数
//        public long getCompletedTaskCount() //已完成的任务数
//        public int getPoolSize() //线程池当前的线程数
//        public int getActiveCount() //线程池中正在执行任务的线程数量

        /**
         * int corePoolSize,//线程池的核心线程数量
         * int maximumPoolSize,//线程池的最大线程数
         * long keepAliveTime,//当线程数大于核心线程数时，多余的空闲线程存活的最长时间
         * TimeUnit unit,//时间单位
         * BlockingQueue<Runnable> workQueue,//任务队列，用来储存等待执行任务的队列
         * ThreadFactory threadFactory,//线程工厂，用来创建线程，一般默认即可
         * RejectedExecutionHandler handler//拒绝策略，当提交的任务过多而不能及时处理时，我们可以定制策略来处理任务
         * 默认策略： ThreadPoolExecutor.AbortPolicy：抛出 RejectedExecutionException来拒绝新任务的处理。
         */
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                                                CORE_POOL_SIZE,
                                                MAX_POOL_SIZE,
                                                KEEP_ALIVE_TIME,
                                                TimeUnit.SECONDS,
                                                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                                                new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 10; i++) {
            //创建WorkerThread对象（WorkerThread类实现了Runnable 接口）
            Runnable worker = new MyRunnable("" + i);
            //执行Runnable
            //1.方式一:无返回值，效率高
            executor.execute(worker);
            //2.方式二：
//            Future task= executor.submit(worker);
        }
        //终止线程池
        executor.shutdown();
        //isTerminated 判断所有提交的任务是否完成（保证之前调用过shutdown方法）
        //awaitTermination 调用shutdown方法后，等待所有任务执行完成
//        while (executor.getActiveCount()>0){}
//        while (!executor.isTerminated()) {
//        }
        while (executor.getActiveCount()!=0){
            try {
                log.info("线程池线程活跃线程数："+executor.getActiveCount());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Finished all threads");
    }
}
