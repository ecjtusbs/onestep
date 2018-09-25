/**
 * @Author: chenhaisheng
 * @Date:   2018-09-25T20:51:33+08:00
 * @Email:  ecjtusbs@foxmail.com
 * @Last modified by:   chenhaisheng
 * @Last modified time: 2018-09-25T20:55:33+08:00
 * @Copyright: ecjtusbs@foxmail.com
 */
 题目描述
 从上往下打印出二叉树的每个节点，同层节点从左至右打印。

 解析:
 借助队列来实现, 遍历队列，过程中压入此节点的左右子节点

 java版实现里借助了系统自带的队列类，因此这里要熟悉java常见的实现了queue接口的类
 import java.util.ArrayList;
 import java.util.LinkedList;

 class TreeNode {
     int val = 0;
     TreeNode left = null;
     TreeNode right = null;

     public TreeNode(int val) {
     this.val = val;
     }
 }

 public class Solution {
     public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
         ArrayList<Integer> res = new ArrayList<>();
         LinkedList<TreeNode> queue = new LinkedList<TreeNode>();

         if (root == null) {
             return res;
         }

         //压入根节点
         queue.add(root);

         //遍历队列，过程中会不断压入新的节点
         while (!queue.isEmpty()) {
             TreeNode tmp = queue.poll();
             if (tmp != null) {
                 //不为空时，打印此节点，然后依次讲左节点、右节点入队列
                 res.add(tmp.val);
                 queue.add(tmp.left);
                 queue.add(tmp.right);
             }
         }
         return res;
     }
 }
