package Multithreading;

/*
* for creating Thread : create a class and extend Thread class
* */
public class Worlds extends Thread{
    @Override
    public void run(){
        for (; ;){
            System.out.println(Thread.currentThread().getName());
        }
    }
}
