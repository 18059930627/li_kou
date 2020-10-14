package com.czj.day5;

/**
 * 8
 * 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
 * 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响
 *
 */
public class Demo3 {
    public int myAtoi(String str) {
        int length = str.length();
        int index = 0; //索引
        char[] chars = str.toCharArray();
        //去除空格
        while (index < length && chars[index] == ' '){
            index++;
        }
        //极端用例 '     '
        if(index == length){
            return 0;
        }
        //判断符号，记录正负号
        int sign = 1;
        char firstChar = chars[index];
        if(firstChar == '-'){
            index++;
            sign = -1;
        }else if(firstChar == '+'){
            index++;
        }

        //进行字符串转数字
        int result = 0;
        //TODO 使用while 不知道什么时候循环结束
        while (index < length){
            char currChar = chars[index];
            if(currChar > '9' || currChar <'0'){
                break;
            }
            //判断是否越界
            if(result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10 && (currChar - '0') > Integer.MAX_VALUE % 10 ) ){
                return Integer.MAX_VALUE;
            }

            if(result < Integer.MIN_VALUE/10 || (result == Integer.MIN_VALUE/10 && (currChar - '0') > -(Integer.MIN_VALUE % 10)  )){
                return Integer.MIN_VALUE;
            }

            result = result * 10 + sign * (currChar - '0');
            index++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Demo3().myAtoi("   a1323"));
    }
}
