package com.czj.day5;

/**
 * 7
 * 整数反转
 * 利用数学方式模仿"弹出"和"推入"
 * pop = x % 10
 * rev = rev*10 + pop
 * x = x/10
 *
 */
public class Demo {

    public int reverse(int x) {
        int result = 0;
        while ((x!=0)){
            int pop = x % 10;
            if(result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10 && pop > Integer.MAX_VALUE % 10)){
                return 0;
            }
            if(result < Integer.MIN_VALUE/10 || (result == Integer.MIN_VALUE/10 && pop < Integer.MIN_VALUE % 10)){
                return 0;
            }
            result = result * 10 + pop;
            x = x /10;
        }
        return result;
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        System.out.println(demo.reverse(123456));
    }
}
