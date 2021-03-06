package com.czj.day9;

/**
 * 27.移除元素
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * 双指针
 */
public class Demo {

    public int removeElement(int[] nums, int val) {
        if(nums.length == 0 || (nums.length == 1 && nums[0] == val)){
            return 0;
        }

        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if(nums[j] != val){
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    /**
     * 优化，防止数组中的每个元素都不一样
     * @param nums
     * @param val
     * @return
     */
    public int removeElement2(int[] nums, int val) {
        if(nums.length == 0 || (nums.length == 1 && nums[0] == val)){
            return 0;
        }

        int i = 0;
        int n = nums.length;

        while (i < n){
            if(nums[i] == val){
                nums[i] = nums[n - 1];
                n--;
            }else{
                i++;
            }
        }

        return i;
    }
}
