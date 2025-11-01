package Multithreading;

/*
* for creating Thread : create a class and extend Thread class
* */
public class Worlds implements Runnable{
    @Override
    public void run(){
        for (; ;){
            System.out.println(Thread.currentThread().getName());
        }
    }
}
