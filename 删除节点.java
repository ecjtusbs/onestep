题目描述：
        给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

        示例：

        给定一个链表: 1->2->3->4->5, 和 n = 2.

        当删除了倒数第二个节点后，链表变为 1->2->3->5.
        说明：

        给定的 n 保证是有效的。

        进阶：

        你能尝试使用一趟扫描实现吗？

解析：用快慢指针，同步后移。


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

//这里的链表都是带头结点的链表
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        //快慢指针，快指针比慢指针提前N个节点
        ListNode fast=head;
        ListNode low=head;

        //操作快慢指针，使得快指针比慢指针提前N个节点
        int tmp=n;
        while(tmp>0&&fast.next!=null){
            fast=fast.next;
        }

        //然后开始同步后移，当fast指向最后一个节点时，low指向待删除节点的前一个节点
        while(fast.next!=null){
            fast=fast.next;
            low=low.next;
        }
        //执行删除操作
        low.next=low.next.next;

        //返回头节点
        return head;
    }
}
