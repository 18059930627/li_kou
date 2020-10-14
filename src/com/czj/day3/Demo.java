package com.czj.day3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *  给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 */
public class Demo {

    public int[] twoSum(int[] nums, int target){
        /*for (int i = 0; i < nums.length; i++) {
            for(int j = i+1;j<nums.length;j++){
                if(target-nums[i]==nums[j]){
                    return new int[]{i,j};
                }
            }
        }*/
        //存入Map
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            int dec = target - nums[i];
            if(map.containsKey(dec) && map.get(dec)!=i ){
                return new int[]{map.get(dec),i};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,3,15};
        Demo demo = new Demo();
        int[] ints = demo.twoSum(nums, 6);
        System.out.println(Arrays.toString(ints));
    }
}
