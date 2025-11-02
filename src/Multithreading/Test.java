package Multithreading;

public class Test {
    public static void main(String[] args) {

        Counter counter = new Counter();
        MyThread t1 = new MyThread(counter);
        MyThread t2 = new MyThread(counter);
        t1.start();
        t2.start(); // 2 threads  , sharing one object(resource)
        try{
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(counter.getCount());
        // variable output : like 1922  : WITHOUT SYNCHRONIZED on increment() method


    }
}
