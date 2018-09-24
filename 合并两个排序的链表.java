/**
 * @Author: chenhaisheng
 * @Date:   2018-09-24T12:20:03+08:00
 * @Email:  ecjtusbs@foxmail.com
 * @Last modified by:   chenhaisheng
 * @Last modified time: 2018-09-24T12:37:01+08:00
 * @Copyright: ecjtusbs@foxmail.com
 */



题目描述
输入两个单调递增的链表，输出两个链表合成后的链表，
当然我们需要合成后的链表满足单调不减规则


解析：
/**维护两个指针分别指向两个list，
*比较大小，小的插入到新list，并后移指针。再次比较大小。
*直到其中一个到达尾部.将另一个list中的剩余元素插入到新list尾部
*/

 /* class ListNode {
     int val;
     ListNode next = null;

     ListNode(int val) {
         this.val = val;
     }
 }*/

  class Solution {
     public static ListNode Merge(ListNode list1, ListNode list2) {
         if (list1 == null) {
             return list2;
         }
         if (list2 == null) {
             return list1;
         }

         //含头结点的list
         ListNode head = new ListNode(-1);
         ListNode tail = head;

         while (list1 != null && list2 != null) {

             //这里判断条件 可写为list1!=null，因为上层循环已经判断过list2!=null
             while (list1 != null && list2!=null) {
                 if (list1.val <= list2.val) {
                     //尾插法插入大数到尾部
                     tail.next = list1;
                     tail = list1;

                     //指向下一个节点
                     list1 = list1.next;

                     //调整尾部，始终指向Null
                     tail.next = null;
                 } else {
                     break;
                 }
             }

             //一定要注意这里的的判断条件，是 list2!=null && list1!=null 而不仅仅是 list2!=null
             //外循环虽然判断了list1!=null && list2!=null，但在执行完上一个循环后，仍然可能会出现list1==null的情况
             while (list2 != null && list1!=null) {
                 if (list2.val <= list1.val) {
                     //尾插法插入大数到尾部
                     tail.next = list2;
                     tail = list2;

                     //指向下一个节点
                     list2 = list2.next;

                     //调整尾部，始终指向Null
                     tail.next = null;
                 }
                 else {
                     break;
                 }
             }
         }

         if (list2 == null) {
             tail.next=list1;
         }
         if (list1 == null) {
             tail.next=list2;
         }
         //按题目要求，返回时不应该含头结点
         return head.next;
     }
 }
