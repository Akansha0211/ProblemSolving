package Multithreading;

import javax.sound.midi.SysexMessage;

public class MyThread extends Thread{


    @Override
    public void run() {
        int i =0;
        while (i<20){
            System.out.println("Hello world");
            i++;
        }
    }
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();

        myThread.start();
        System.out.println(Thread.currentThread().getState());
        myThread.join();
        System.out.println(myThread.getState());
        System.out.println(Thread.currentThread().getState());
    }
    //Daemon tHREAD : runs in background, JVM does not wait fot them
    // JVM just sees main method is completed and all user threads are completed, it gets terminated



}
