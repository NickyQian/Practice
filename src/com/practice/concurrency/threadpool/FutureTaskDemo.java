package com.practice.concurrency.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Submit与execute的区别 1. 接收的参数不一样 2. submit有返回值，而execute没有 3. submit方便Exception处理
 * 
 * @author Nick
 *
 */
public class FutureTaskDemo {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<String>> resultList = new ArrayList<Future<String>>();

        // 创建10个任务并执行
        for (int i = 0; i < 10; i++) {
            // 使用ExecutorService执行Callable类型的任务，并将结果保存在future变量中
            Future<String> future = executorService
                    .submit(new TaskWithResult(i));
            // 将任务执行结果存储到List中
            resultList.add(future);
        }
        Thread.sleep(1000);
        /**
         * shutdown调用后，不可以再submit新的task，已经submit的将继续执行。
         * shutdown()方法在终止前允许执行以前提交的任务。
         */
        executorService.shutdown();

        // 遍历任务的结果
        for (Future<String> fs : resultList) {
            try {
                System.out.println(fs.get()); // 打印各个线程（任务）执行的结果
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                /**
                 * shutdownNow()方法阻止等待任务启动并试图停止当前正在执行的任。
                 * shutdownNow试图停止当前正执行的task，并返回尚未执行的task的list
                 */
                executorService.shutdownNow();
                e.printStackTrace();
                return;
            }
        }
    }
}

class TaskWithResult implements Callable<String> {
    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    /**
     * 任务的具体过程，一旦任务传给ExecutorService的submit方法，则该方法自动在一个线程上执行。
     * 
     * @return
     * @throws Exception
     */
    public String call() throws Exception {
        System.out.println("call()方法被自动调用,干活！！！             "
                + Thread.currentThread().getName());
        if (new Random().nextBoolean())
            throw new TaskException("Meet error in task."
                    + Thread.currentThread().getName());
        // 一个模拟耗时的操作
        // for (int i = 999999999; i > 0; i--)
        // ;
        return "call()方法被自动调用，任务的结果是：" + id + "    "
                + Thread.currentThread().getName();
    }
}

class TaskException extends Exception {
    private static final long serialVersionUID = 1L;

    public TaskException(String message) {
        super(message);
    }
}