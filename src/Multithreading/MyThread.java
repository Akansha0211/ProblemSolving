package Multithreading;

import javax.sound.midi.SysexMessage;

public class MyThread extends Thread{

    public MyThread(String name){
        super(name); // calling Thread class constuctor
    }
    @Override
    public void run() {
        for(int i =0; i<5; i++){
            System.out.println(Thread.currentThread().getName() +
                    " - Priority : " + Thread.currentThread().getPriority() + " - count " + i);
            try{
                Thread.sleep(100);
            }catch (Exception e){

            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread("thread akansha");
        MyThread t2 = new MyThread("thread ayush");
        MyThread t3 = new MyThread("thread honey");
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.NORM_PRIORITY);
        t3.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
        t3.start();
    }
}
