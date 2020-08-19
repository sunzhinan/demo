package com.example.demo.basis.thread.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author : sun
 * create at:  2020/5/7  21:15
 * @description: 线程池测试类
 */
public class TestThreadPool {
    static boolean isPrime(int num){
        for (int i = 2; i <= num/2; i++) {
            if (num % i ==0) return false;
        }
        return true;
    }

    static List<Integer> getPrime(int start , int end)
    {
        List<Integer> results = new ArrayList<>();
        for (int i=start;i<=end;i++){
            if(isPrime(i)) results.add(i);
        }

        return results;
    }

    static class MyTask implements Callable<List<Integer>> {
        int start ;
        int end;

        public MyTask(int start,int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public List<Integer> call() throws Exception {
            List<Integer> r= getPrime(start,end);
            return r;
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        getPrime(1,200000);
        long end = System.currentTimeMillis();

        System.out.println(end - start);


        ExecutorService service = Executors.newFixedThreadPool(4);
        MyTask t1 = new MyTask(1,50000);
        MyTask t2 = new MyTask(50001,100000);
        MyTask t3 = new MyTask(100001,150000);
        MyTask t4 = new MyTask(150001,200000);

        /**
         * 这里为什么用callable,我觉得是因为方便计算时间
         * 因为f1,f2,f3,f4 get拿到结果一定是线程执行完了的
         * 如果用runnable，则是异步执行，不方便去计算时间
         */
        Future<List<Integer>> f1 = service.submit(t1);
        Future<List<Integer>> f2 = service.submit(t2);
        Future<List<Integer>> f3 = service.submit(t3);
        Future<List<Integer>> f4 = service.submit(t4);
        try {
            long l1 = System.currentTimeMillis();
            f1.get();
            f2.get();
            f3.get();
            f4.get();
            long l2 = System.currentTimeMillis();
            System.out.println(l2 - l1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        service.shutdown();
    }
}
