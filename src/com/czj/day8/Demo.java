package com.czj.day8;

/**
 * 26.删除排序数组中的重复项
 *  给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *  不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *  有序
 *  方法：双指针法 -> 画图理解
 *  就是将不重复的元素移动数组的左侧
 */
public class Demo {

    public int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if(nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    /**
     * 优化
     * 每个元素都不一样，相当于是复制一遍数组元素
     * @param nums
     * @return
     */
    public int removeDuplicates2(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if(nums[i] != nums[j]){
                if(j - i > 1){
                    nums[i + 1] = nums[j];
                }
                i++;

            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int [] nums = new int[]{1,1,2};
        System.out.println(new Demo().removeDuplicates(nums));
    }
}
