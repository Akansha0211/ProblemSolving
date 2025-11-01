package Multithreading;

import javax.sound.midi.SysexMessage;

public class MyThread extends Thread{

    public MyThread(String name){
        super(name); // calling Thread class constuctor
    }
    @Override
    public void run() {
        try{
            Thread.sleep(10000);
            System.out.println("Thread is running");
        }catch (InterruptedException e){
            System.out.println("Thread interuppted");
        }
    }
    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread("thread akansha");
        t1.start();
        t1.interrupt(); // whatever t1 thread is doing get interuppted
    }
}
