package org.multithreading;

public class MyFirstThread implements Runnable{

    private Worker worker;

    public MyFirstThread(Worker worker) {
        this.worker = worker;
    }

    public MyFirstThread() {
    }

    @Override
    public void run() {
        System.out.println("wow, im in thread-1");
        //worker.addTask("simple");
        worker.addNextTaskToQueue("simple");
        System.out.println("task added by " + Thread.currentThread().getName());
    }
}
