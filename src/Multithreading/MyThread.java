package Multithreading;

import javax.sound.midi.SysexMessage;

public class MyThread extends Thread{


    @Override
    public void run() {
        int i =0;
        while (i<5){
            System.out.println(MyThread.currentThread().isDaemon()+ " : " +"Hello world");
            i++;
        }
        System.out.println( MyThread.currentThread().getState());
    }
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.setDaemon(true);

        MyThread t2 =new MyThread();
        myThread.start();
        t2.start();


        System.out.println("Main done");
    }
    //Daemon tHREAD : runs in background, JVM does not wait fot them
    // JVM just sees main method is completed and all user threads are completed, it gets terminated

    // Main class executed , user thread executed,
    // so JVM terminates , and daemon thread is not completeky executed
//    Main done
//false : Hello world
//false : Hello world
//false : Hello world
//false : Hello world
//false : Hello world
//    RUNNABLE
//true : Hello world
//true : Hello world
//true : Hello world
//true : Hello world


}
