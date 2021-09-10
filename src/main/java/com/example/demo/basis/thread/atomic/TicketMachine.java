package com.example.demo.basis.thread.atomic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: sunzhinan
 * @create: 2021-07-01 23:24
 * @description: 售票
 */
public class TicketMachine implements Runnable{
    static AtomicInteger ticket = new AtomicInteger(1000);
    static AtomicInteger num = new AtomicInteger(0);

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        while (ticket.get() > 0){
            sell();
        }
    }

    private static void sell(){
        ticket.getAndDecrement();
        num.incrementAndGet();
    }

    public static void main(String[] args) throws Exception{
        TicketMachine ticketMachine = new TicketMachine();
        Thread conductorA = new Thread(ticketMachine , "ThreadA");
        Thread conductorB = new Thread(ticketMachine , "ThreadB");
        conductorA.start();
        conductorB.start();

        TimeUnit.SECONDS.sleep(2);
        System.out.println(num.get());
    }
}
