/**
 * @Author: chenhaisheng
 * @Date:   2018-09-24T10:25:25+08:00
 * @Email:  ecjtusbs@foxmail.com
 * @Last modified by:   chenhaisheng
 * @Last modified time: 2018-09-24T10:26:08+08:00
 * @Copyright: ecjtusbs@foxmail.com
 */
 /*
 public class ListNode {
     int val;
     ListNode next = null;

     ListNode(int val) {
         this.val = val;
     }
 }*/

题目描述
输入一个链表，反转链表后，输出新链表的表头。

 /*这里所有的链表均为不带头结点的链表
 如果为带头结点的链表，代码会更简洁*/
 public class Solution {
     public ListNode ReverseList(ListNode head) {

         if (head == null) {
             return null;
         }

         //创建新链表,调整新表表头指向旧表第一个
         ListNode newHead = head;
         head = head.next;

         //新表表头的next设置为空
         newHead.next = null;

         //从旧表的第二个元素开始，头插法插入到新表
         while (head != null) {

             ListNode tmp = head.next;

             head.next = newHead;
             newHead = head;

             head = tmp;
         }

         return newHead;
     }
 }
