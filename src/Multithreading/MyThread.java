package Multithreading;

public class MyThread extends Thread{
    @Override
    public void run() {

        System.out.println("print: RUNNING STATE");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();
        System.out.println(t1.getState()); // NEW STATE
        t1.start();
        System.out.println(t1.getState()); // RUNNABLE STATE

        System.out.println(Thread.currentThread().getState()); // main thread's state
        Thread.sleep(100);
        System.out.println("main thread " + Thread.currentThread().getState());
        System.out.println(t1.getState());
        t1.join(); // main method waits t1 to get completed
        System.out.println(t1.getState());

//        NEW
//        RUNNABLE
//        RUNNABLE  / RUNNING ( main thread)
//        print: RUNNING STATE
//        TIMED_WAITING

        // if we don't use t1.join() --> main method won't wait fro thread t1 for its completion

    }
}
