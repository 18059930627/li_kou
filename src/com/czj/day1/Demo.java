package com.czj.day1;


/**
 * 108
 * 将有序数组转换为二叉搜索树
 * 1、将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 2、本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 */
public class Demo {

    public TreeNode sortedArrayToBST(int[] nums) {
        return help(nums,0,nums.length-1);
    }

    private TreeNode help(int[] nums, int left, int right) {

        if(left>right){
            return null;
        }

        int mid = (right+left)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = help(nums,left,mid-1);
        root.right = help(nums,mid+1,right);
        return root;
    }


    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        Demo demo = new Demo();
        TreeNode treeNode = demo.sortedArrayToBST(nums);
        System.out.println(treeNode);
    }

    class TreeNode{

        int val;

        TreeNode left;

        TreeNode right;

        TreeNode(int x) { val = x; }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
