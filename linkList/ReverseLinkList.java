/**
 * @Author: chenhaisheng
 * @Date:   2018-09-21T22:04:42+08:00
 * @Email:  ecjtusbs@foxmail.com
 * @Last modified by:   chenhaisheng
 * @Last modified time: 2018-09-22T15:17:14+08:00
 * @Copyright: ecjtusbs@foxmail.com
 */

// 题目：
// 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
//
/**
*    public class ListNode {
*        int val;
*        ListNode next = null;
*
*        ListNode(int val) {
*            this.val = val;
*        }
*    }
*
*/


import java.util.ArrayList;
public class Solution {

    //思路：翻转链表，依次添加到arraylist
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        //新链表的头节点
        ListNode head=new ListNode(0);

        //arrList
        ArrayList <Integer> arrList=new ArrayList();

        //为空直接返回
        if(listNode==null){
        	return arrList;
        }

		ListNode tmp=null;

		//头插法依次将原链表中的元素插入新链表中
        while(listNode!=null){
				//保存当前待插入节点的后一个节点
				tmp=listNode.next;

				//头插法插入当前节点新链表中
				listNode.next=head.next;
				head.next=listNode;

                //下一个待插入节点
				listNode=tmp;//指向下一个节点
        }

        //遍历新链表，依次插入到arrlist中
        tmp=head.next;
        while(tmp!=null){
        	arrList.add(tmp.val);
            tmp=tmp.next;
        }
        return arrList;
    }
}
