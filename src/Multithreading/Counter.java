package Multithreading;

public class Counter {

    private int count = 0;

    public void increment(){
        // synchronized block
        synchronized (this){
            // this : one instance , multiple threads accessing it , only one thread can access it
            // multple objects of Counter, indp

            // method / Block : Synchronized
            count++;
        }
    }
    public int getCount(){
        return count;
    }
}
