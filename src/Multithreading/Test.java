package Multithreading;

public class Test {
    public static void main(String[] args) {
        // create a object , and use start() method
        Worlds world = new Worlds(); // NEW STATE
//        world.start(); available in thread class
        Thread t1 = new Thread(world);
        t1.start(); // RUNNABLE STATE

        for(; ;){
            System.out.println(Thread.currentThread().getName());
        }

        // main
        // Thread-0
        // ... infinite times
        // no order folowed ( execution in random order)
        // 2 independenct task


    }
}
