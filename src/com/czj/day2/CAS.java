package com.czj.day2;

public class CAS {

    static volatile int num;


    public int addOne(int value){
        do{
            num = value;
        }while (!compareAndSwap(num,num+1));
        return num;
    }

    public boolean compareAndSwap(int value,int except){
        synchronized (this){
            if(value!=num){
                return false;
            }
            num = except;
            return true;
        }
    }
}
