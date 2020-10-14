package com.czj.day7;

/**
 * 21.合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 链表问题考虑哑节点
 */
public class Demo {

      //迭代
   /* public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);   //哑节点
        ListNode currListNode = listNode;

        while(l1 != null && l2!= null){
            if(l1.val > l2.val){
                currListNode.next = l2;
                l2 = l2.next;
            }else {
                currListNode.next = l1;
                l1 = l1.next;
            }
            currListNode = currListNode.next;  //为什么在这里，listNode没变
        }

        if(l1 == null){
            currListNode.next = l2;
        }else {
            currListNode.next = l1;
        }


        return listNode.next;
    }*/

    /**
     * 递归函数必须要有终止条件，否则会出错。
     * 递归函数先不断调用自身，直到遇到终止条件后进行回溯，最终返回答案。
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> aClass = Demo.class;
        System.out.println(aClass.getSimpleName());
        System.out.println();

        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(3);
        listNode.next = listNode1;
        ListNode listNode2 = new ListNode(5);
        listNode1.next = listNode2;
        System.out.println(listNode);

        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(4);
        listNode3.next = listNode4;
        ListNode listNode5 = new ListNode(6);
        listNode4.next = listNode5;
        System.out.println(listNode3);

        System.out.println(new Demo().mergeTwoLists(listNode,listNode3));
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
