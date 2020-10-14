package com.czj.day5;

/**
 * 9.回文数
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 回文数只要判断一半
 *
 */
public class Demo2 {

    public boolean isPalindrome(int x) {
        if(x < 0 || (x%10 == 0 && x != 0)){
            return false;
        }
        int revertedNumber = 0;
        while (x > revertedNumber){
            revertedNumber = revertedNumber * 10 + x % 10;
            x = x/10;
        }
        return x==revertedNumber || x == revertedNumber/10;
    }

    public static void main(String[] args) {
        System.out.println(new Demo2().isPalindrome(1233456));
    }
}
