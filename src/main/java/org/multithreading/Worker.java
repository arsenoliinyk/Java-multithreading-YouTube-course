package org.multithreading;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Worker {

    private volatile Deque<String> queue = new LinkedList<>();

    private BlockingQueue<String> concurrentLinkedQueue = new LinkedBlockingQueue<>();

    public synchronized void doWork() {
        //in fact, do nothing
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("i am working");
    }

    public synchronized void addTask(String taskName) {
        try {
            Thread.sleep(1000);
            queue.add(taskName);
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized String getNextTask() {
        String nextTask = null;
        try {
            do {
                nextTask = queue.poll();
                System.out.println("checking");
                if (nextTask == null) {
                    wait();
                } else {
                    break;
                }
            } while (true);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        return queue.poll();
    }

    public void addNextTaskToQueue(String taskName) {
        concurrentLinkedQueue.add(taskName);
    }

    public String getNextTaskFromQueue() {
        return concurrentLinkedQueue.poll();
    }
}
