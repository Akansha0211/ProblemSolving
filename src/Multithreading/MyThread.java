package Multithreading;

import javax.sound.midi.SysexMessage;

public class MyThread extends Thread{
    @Override
    public void run() {
//        for (int i = 1; i<=5; i++){
//            try {
//                Thread.sleep(1000);// current thread execution suspended for specified period of time
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            System.out.println(i);
//        }
        try {
            Thread.sleep(5000);// current thread execution suspended for specified period of time
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        MyThread t1 = new MyThread();
//        t1.start();
//        System.out.println(t1.getState());
//        System.out.println("hello");
//        System.out.println(Thread.currentThread().getState());
//        System.out.println(t1.getState()); // TIMED_WAITING or RUNNABLE
//        RUNNABLE
//        hello
//        RUNNABLE
//        TIMED_WAITING

//        RUNNABLE
//        hello
//        RUNNABLE
//        RUNNABLE

        MyThread t1 = new MyThread();
        t1.start();
        System.out.println(t1.getState());
        System.out.println("hello");
        t1.join();
        System.out.println(Thread.currentThread().getState());
        System.out.println(t1.getState());

//        RUNNABLE
//        hello
//        RUNNABLE
//        TERMINATED

    }
}
