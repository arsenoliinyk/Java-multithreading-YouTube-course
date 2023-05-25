package org.multithreading;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        Worker worker = new Worker();

        System.out.println(Thread.currentThread().getName());

        MyFirstThread thread = new MyFirstThread(worker);
        //thread.run();

        //create thread
        Thread firstThread = new Thread(thread);
        firstThread.start();

        System.out.println("almost done");

        MySecondThread secondThread = new MySecondThread(worker);
        secondThread.start();

        MySecondThread anotherSecondThread = new MySecondThread(worker);
        anotherSecondThread.start();
    }
}
