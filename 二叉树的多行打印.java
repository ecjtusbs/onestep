/**
 * @Author: chenhaisheng
 * @Date:   2018-09-30T17:22:35+08:00
 * @Email:  ecjtusbs@foxmail.com
 * @Last modified by:   chenhaisheng
 * @Last modified time: 2018-09-30T17:34:26+08:00
 * @Copyright: ecjtusbs@foxmail.com
 */
题目描述
从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。

解析：维护两个队列，对应树的两层，交替入队列出队列

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {
        ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {

        ArrayList<ArrayList<Integer>> res=new ArrayList();
        if(pRoot==null){
            return res;
        }

        //维护两个队列
        LinkedList<TreeNode> queA=new LinkedList();
        LinkedList<TreeNode> queB=new LinkedList();

        //初始化队列A，此时保存的是root节点
        queA.add(pRoot);

        //停止条件为两个队列均为空
        while(queA.size()>0||queB.size()>0){

            ArrayList tmpA=new ArrayList();
            while(queA.size()>0){
                //peek()查看list的head元素，但不删除
                TreeNode head=queA.peek();
                //左右子树入B队列
                if(head.left!=null){
                     queB.add(head.left);
                }
                if(head.right!=null){
                     queB.add(head.right);
                }
                //出A队列，pop()会删除head元素
                tmpA.add(queA.pop().val);
            }
            //加入到打印队列之前要先判断tmpA是否为空
            if(tmpA.size()>0){
                res.add(tmpA);
            }

            ArrayList tmpB=new ArrayList();
            while(queB.size()>0){
                TreeNode head=queB.peek();
                if(head.left!=null){
                   queA.add(head.left);
                }
                if(head.right!=null){
                    queA.add(head.right);
                }
                tmpB.add(queB.pop().val);
            }
            if(tmpB.size()>0){
                res.add(tmpB);
            }
        }
        return res;
    }
}
