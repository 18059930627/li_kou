package com.czj.day11;

/**
 * 35.搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 */
public class Demo {

    public int searchInsert2(int[] nums, int target) {
        if(nums.length == 0 || nums[0] > target){
            return 0;
        }

        if(nums[nums.length-1] < target){
            return nums.length;
        }

        //二分查找
        int indexResult = binarySearch(nums, 0, nums.length, target);
        if(indexResult == -1){
            //遍历
            for (int i = 0; i < nums.length; i++) {
                if(nums[i] <=  target && target < nums[i+1]){
                    return i+1;
                }
            }
        }
        return indexResult;
    }

    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0 || nums[0] > target){
            return 0;
        }

        if(nums[nums.length-1] < target){
            return nums.length;
        }

        //二分查找
        //遍历
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == target){
                return i;
            }
            if(nums[i] <  target && target < nums[i+1]){
                return i+1;
            }
        }
        return 0;
    }

    public int searchInsert3(int[] nums, int target) {

        //二分查找
        int indexResult = binarySearch(nums, 0, nums.length-1, target);
        return indexResult;
    }

    private int binarySearch(int[] array, int start, int end, int target) {
        if(start > end){
            return start;
        }
        int mid = start + (end - start) /2;
        if(array[mid] > target){
            return binarySearch(array, start, mid -1, target);
        }else if(array[mid] < target){
            return binarySearch(array, mid+1, end, target);
        }else {
            return mid;
        }
    }

    public static void main(String[] args) {
        int nums[] = new int[]{1,3,5,6};
        int target = 2;
        System.out.println(new Demo().searchInsert3(nums,target));
    }
}
