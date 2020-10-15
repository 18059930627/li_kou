package com.czj.day10;

/**
 * 28.实现 strStr() 函数。
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 */
public class Demo {

    /**
     * 字符串逐一比较
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if(haystack.length() < needle.length() || (haystack.length() == 0 && needle.length() != 0)){
            return -1;
        }
        if("".equals(needle)){
            return 0;
        }

        for (int i = 0; i < haystack.length(); i++) {

            if(haystack.charAt(i) == needle.charAt(0)){
                //截取字符串 判断是否相等
                if(haystack.length() - i < needle.length()){
                    return -1;
                }

                if(haystack.substring(i,i+needle.length()).equals(needle)){
                    return i;
                }
            }

        }
        return -1;
    }


    /**
     * 双指针方法
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr2(String haystack, String needle) {
        int L = needle.length(), n = haystack.length();
        if (L == 0) return 0;

        int pn = 0;
        while (pn < n - L + 1) {
            // find the position of the first needle character
            // in the haystack string
            while (pn < n - L + 1 && haystack.charAt(pn) != needle.charAt(0)) ++pn;

            // compute the max match string
            int currLen = 0, pL = 0;
            while (pL < L && pn < n && haystack.charAt(pn) == needle.charAt(pL)) {
                ++pn;
                ++pL;
                ++currLen;
            }

            // if the whole needle string is found,
            // return its start position
            if (currLen == L) return pn - L;

            // otherwise, backtrack
            pn = pn - currLen + 1;
        }
        return -1;
    }





    public static void main(String[] args) {
        /*String haystack = "hello";
        String needle = "ll";*/
        String haystack = "aaaaa";
        String needle = "bba";
        System.out.println(new Demo().strStr(haystack,needle));
    }
}
