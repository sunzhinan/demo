package com.example.demo.basis.thread.future;

import java.util.concurrent.*;

/**
 * @author: sunzhinan
 * @create: 2020-07-21 00:41
 * @description:
 */
public class UseFuture  implements Callable {
    private String para;

    public UseFuture(String para){
        this.para = para;
    }

    /**
     * 这里是真实的业务逻辑，其执行可能很慢
     */
    @Override
    public String call() throws Exception {
        if(para=="query1"){
            //模拟执行耗时
            Thread.sleep(3000);
        }
        if(para=="query2"){
            //模拟执行耗时
            Thread.sleep(5000);
        }
        String result = this.para + "处理完成";
        return result;
    }

    //主控制函数
    public static void main(String[] args) throws Exception {
        String queryStr1 = "query1";
        String queryStr2 = "query2";
        //构造FutureTask，并且传入需要真正进行业务逻辑处理的类,该类一定是实现了Callable接口的类
        FutureTask<String> future1 = new FutureTask<String>(new UseFuture(queryStr1));
        FutureTask<String> future2 = new FutureTask<String>(new UseFuture(queryStr2));

        //创建一个固定线程的线程池且线程数为1,
        ExecutorService executor = Executors.newFixedThreadPool(2);

        //这里提交任务future,则开启线程执行RealData的call()方法执行
        Future freturn1 = executor.submit(future1);
        Future freturn2 = executor.submit(future2);
        System.out.println("主函数为future1和future2开启了两个线程，接下来主函数可以继续执行，不必等到这两个线程执行完毕");

        // submit和excute的区别在于submit有返回值，执行成功返回null
    /*while(true){
        if(freturn1==null){
            System.out.println("submit是有返回值的，返回值1表示future1执行完毕");
            break;
        }
    }

    while(true){
        if(freturn2==null){
            System.out.println("submit是有返回值的，返回值1表示future2执行完毕");
            break;
        }
    }*/

        try {
            //这里可以做额外的数据操作，也就是主程序执行其他业务逻辑
            System.out.println("我是主函数，我继续忙自己的事儿");
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //调用获取数据方法,如果call()方法没有执行完成,则依然会进行等待
        System.out.println("我是future1,我从开始到结束运行需要3秒，我的执行结果为：" + future1.get());
        System.out.println("我是future2,我从开始到结束运行需要5秒，我的执行结果为：" + future2.get());
        executor.shutdown();
    }

}
