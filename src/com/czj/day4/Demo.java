package com.czj.day4;

import javax.swing.tree.TreeNode;

/**
 * 226 翻转二叉树
 */
public class Demo {

    public TreeNode invertTree(TreeNode root) {
       if(root == null){
           return null;
       }
       //保存右子树
        TreeNode leftNode = invertTree(root.left);
        TreeNode rightNode = invertTree(root.right);
        root.left = rightNode;
        root.right = leftNode;
        return root;
    }

     class TreeNode {
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
