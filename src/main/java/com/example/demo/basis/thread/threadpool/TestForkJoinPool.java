package com.example.demo.basis.thread.threadpool;

import lombok.Data;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * @author: sunzhinan
 * @create: 2020-05-24 19:46
 * @description: ForkJoinPool——实现1+100
 */
public class TestForkJoinPool {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool  forkJoinPool = new ForkJoinPool();
        Task task = new Task(1,100);
        Future<Integer> future = forkJoinPool.submit(task);
        System.out.println(future.get());
    }

}

@Data
class Task extends RecursiveTask<Integer>{

    private final static int MAX_VALUE = 10;

    private int start;

    private int end;

    public Task(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;

        //判断任务最小数阈值——这里设置为10，意思就是说，我将1加到100分成了1加到10，11加到20等等
        boolean flag = (end - start) <= MAX_VALUE;

        if(flag){
            for (int i = start;i<=end;i++){
                sum += i;
            }
        }else{
            //继续分割任务
            int min = (start + end)/2;
            Task task1 = new Task(start,min);
            Task task2 = new Task(min+1,end);

            //执行子任务
            task1.fork();
            task2.fork();

            //汇总子任务结果
            int  result1 = task1.join();
            int  result2 = task2.join();

            //合并子任务
            sum = result1 + result2;
        }

        return sum;
    }
}
