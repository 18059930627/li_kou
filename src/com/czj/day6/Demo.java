package com.czj.day6;


/** 14
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class Demo {

    /*public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0 || strs == null){
            return "";
        }
        //应该要以数组中最短的字符串为准
        int minLength = Integer.MAX_VALUE;
        //最短字符串的下标
        int minIndex = 0;
        for (int i = 0; i < strs.length; i++) {
            int length = strs[i].length();
            if(length < minLength){
                minLength = length;
                minIndex = i;
            }
        }

        //如果最短字符串长度为0，则输出""
        if(minLength == 0){
            return "";
        }

        //寻找公共前缀 - 最短的字符串的位置 - 以最短的字符串为基准进行遍历
        char[] chars = strs[minIndex].toCharArray();
        int endIndex = 0;
        boolean flag = false;
        for (int i = 0; i < minLength; i++) {
            char currChar = chars[i];
            //遍历剩余的字符串
            for (int j = 0; j < strs.length; j++) {
                if(currChar == strs[j].charAt(i)){
                    flag = true;
                }else {
                    flag = false;
                    break;
                }
            }
              if(flag){
                  endIndex = i + 1;
              }else {
                  endIndex = i;
                  break;
              }
        }
        return strs[minIndex].substring(0,endIndex);
    }*/

    //横向扫描
   /* public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; i++) {  //遍历字符串数组
            prefix = longestCommonPrefix(prefix, strs[i]);  //查找最长公共前缀  两两比较
            if (prefix.length() == 0) {  //数组中存在空字符串  最长公共前缀已经是空串，则最长公共前缀一定是空串，就不需要继续遍历剩下字符串了
                break;
            }
        }
        return prefix;
    }

    public String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());  //以最短为基准
        int index = 0;
        //不知道循环次数 用while
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }*/

    //纵向扫描
    /*public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        int count = strs.length;
        //遍历次数第一个字符串的长度
        for (int i = 0; i < length; i++) {
            char currChar = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if( i == strs[j].length() || strs[j].charAt(i) != currChar ){
                    return strs[0].substring(0,i);
                }
            }
        }
        //遍历字符串数组中字符串的个数
        return strs[0];
    }*/


    //分治
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        } else {
            return longestCommonPrefix(strs, 0, strs.length - 1);
        }
    }

    public String longestCommonPrefix(String[] strs, int start, int end) {
        if (start == end) {
            return strs[start];
        } else {
            int mid = (end - start) / 2 + start;
            String lcpLeft = longestCommonPrefix(strs, start, mid);
            String lcpRight = longestCommonPrefix(strs, mid + 1, end);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    public String commonPrefix(String lcpLeft, String lcpRight) {
        int minLength = Math.min(lcpLeft.length(), lcpRight.length());
        for (int i = 0; i < minLength; i++) {
            if (lcpLeft.charAt(i) != lcpRight.charAt(i)) {
                return lcpLeft.substring(0, i);
            }
        }
        return lcpLeft.substring(0, minLength);
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"flower","flow","flight","f"};
        //String[] strs = new String[]{"a"};
        //String[] strs = new String[]{"dog","","car"};
        System.out.println(new Demo().longestCommonPrefix(strs));
    }
}
