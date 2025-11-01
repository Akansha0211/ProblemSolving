package Multithreading;

import javax.sound.midi.SysexMessage;

public class MyThread extends Thread{

    public MyThread(String name){
        super(name); // calling Thread class constuctor
    }
    @Override
    public void run() {
        for (int  i =0; i<5; i++){
            System.out.println(Thread.currentThread().getName() + " is running ");
            //Thread.yield();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread("thread akansha");
        MyThread t2 = new MyThread("thread ayush");
        t1.start();
        t2.start();
    }

    // without yield : random result
//    thread ayush is running
//    thread ayush is running
//    thread ayush is running
//    thread akansha is running
//    thread ayush is running
//    thread akansha is running
//    thread ayush is running
//    thread akansha is running
//    thread akansha is running
//    thread akansha is running

    // with yield() method
//    thread akansha is running
//    thread ayush is running
//    thread akansha is running
//    thread ayush is running
//    thread akansha is running
//    thread ayush is running
//    thread akansha is running
//    thread ayush is running
//    thread akansha is running
//    thread ayush is running
}
