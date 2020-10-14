package com.czj.day2;

public class Client {

    public static void main(String[] args) {

        CAS cas = new CAS();

        final int value = 0;
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
               cas.addOne(value);
            }).start();
        }
        System.out.println(CAS.num);
    }
}
