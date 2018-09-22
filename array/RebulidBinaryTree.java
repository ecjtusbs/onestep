/**
 * @Author: chenhaisheng <chen>
 * @Date:   2018-09-22T14:24:18+08:00
 * @Email:  ecjtusbs@foxmail.com
 * @Last modified by:   chen
 * @Last modified time: 2018-09-22T14:29:31+08:00
 * @Copyright: ecjtusbs@foxmail.com
 */



题目描述
输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {

        if(pre.length==0){
            return null;
        }
        if(pre.length==1){
            return new TreeNode(pre[0]);
        }

        int root=pre[0];
        int rootIndex=0;

        //找到根节点在中序遍历序列中的位置
        for(int i=0;i<in.length;i++){
            if(root==in[i]){
            rootIndex=i;
            break;
            }
        }

        int leftTreeNodes=rootIndex;//左子树总节点个数;
        int rightTreeNodes=in.length-leftTreeNodes-1;//右子树节点个数

        int[] leftTree=new int[leftTreeNodes];//左子树前序遍历序列
        int[] rightTree=new int[rightTreeNodes];//右子树前序遍历序列

        int[] leftTreeMiddle=new int[leftTreeNodes];//左子树中序遍历序列
        int[] rightTreeMiddle=new int[rightTreeNodes];//右子树中序遍历序列


        //前序遍历序列赋值
        //左前序
        for(int i=0;i<leftTreeNodes;++i){
            leftTree[i]=pre[i+1];
        }
        //右前序
        for(int i=0;i<rightTreeNodes;i++){
            rightTree[i]=pre[leftTreeNodes+1+i];
        }


        //中序遍历序列赋值
        //左中序
        for(int i=0;i<leftTreeNodes;i++){
            leftTreeMiddle[i]=in[i];
        }
        //右中序
        for(int i=0;i<rightTreeNodes;i++){
            rightTreeMiddle[i]=in[i+1+leftTreeNodes];
        }

        //根节点
        TreeNode treenode=new TreeNode(root);
        //左子树先序和左子树中序
        treenode.left=reConstructBinaryTree(leftTree, leftTreeMiddle);
        //右子树先序和右子树中序
        treenode.right=reConstructBinaryTree(rightTree, leftTreeMiddle);

        return treenode;


    }
}
