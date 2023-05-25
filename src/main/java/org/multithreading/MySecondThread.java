package org.multithreading;

public class MySecondThread extends Thread{

    private Worker worker;

    public MySecondThread(Worker worker) {
        super();
        this.worker = worker;
    }

    public MySecondThread() {}

    @Override
    public void run(){
        System.out.println("wow, im in thread-2 " + Thread.currentThread().getName());
        //System.out.println(worker.getNextTask() + " was taken by " + Thread.currentThread().getName());
        System.out.println(worker.getNextTaskFromQueue() + " was taken by " + Thread.currentThread().getName());
    }
}
