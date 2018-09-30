/**
 * @Author: chenhaisheng
 * @Date:   2018-09-30T09:15:09+08:00
 * @Email:  ecjtusbs@foxmail.com
 * @Last modified by:   chenhaisheng
 * @Last modified time: 2018-09-30T09:24:36+08:00
 * @Copyright: ecjtusbs@foxmail.com
 */

 题目描述
 输入两个链表,找出它们的第一个公共结点.

 解析：找到长度差，然后移动到距离尾部同一起始位置,逐个比较即可.

 public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        //统计长度
        int len1=0;
        ListNode tmp=pHead1;
        while(tmp!=null){
            tmp=tmp.next;
            len1++;
        }

        int len2=0;
        tmp=pHead2;
        while(tmp!=null){
            tmp=tmp.next;
            len2++;
        }

        //调整两链表，使其至尾部长度相同
        if(len1>=len2){
            int k=len1-len2;
            while(k-->0){
                pHead1=pHead1.next;
            }
        }else{
            int k=len2-len1;
            while(k-->0){
                pHead2=pHead2.next;
            }
        }

         while(pHead1!=null&&pHead2!=null){
            if(pHead1.val==pHead2.val){
                return pHead1;
            }else{
                pHead1=pHead1.next;
                pHead2=pHead2.next;
            }
        }
     return null;
    }
}
