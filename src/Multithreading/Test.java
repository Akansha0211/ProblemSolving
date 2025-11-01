package Multithreading;

public class Test {
    public static void main(String[] args) {
        // create a object , and use start() method
        Worlds world = new Worlds();
        world.start();
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
