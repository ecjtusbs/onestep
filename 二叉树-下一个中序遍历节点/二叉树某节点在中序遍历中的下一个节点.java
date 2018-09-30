/**
 * @Author: chenhaisheng
 * @Date:   2018-09-30T13:07:07+08:00
 * @Email:  ecjtusbs@foxmail.com
 * @Last modified by:   chenhaisheng
 * @Last modified time: 2018-09-30T16:16:31+08:00
 * @Copyright: ecjtusbs@foxmail.com
 */
 题目描述
 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。

解析:按情况划分：
1.有右子树
    1.1 返回右子树中序遍历序列的第一个节点
2.无右子树时
    2.1 找到满足下列要求的第一个祖父节点：
        a.有右子树
        b.当前节点在此祖父节点的左子树上
        返回此祖父节点

 /*
public class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
*/

public class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        //1、当前节点有右子树
            TreeLinkNode rightChild=pNode.right;
            if(rightChild!=null){
                //查找右节点的第一个左节点
                if(rightChild.left==null){
                    //当前节点的右节点没有左子树，
                    //返回当前节点的右节点作为后续遍历的下一个节点
                    return rightChild;
                }else{
                    //当前节点右节点有左子树
                    TreeLinkNode subTreeNode=rightChild.left;
                    while(subTreeNode.left!=null){
                        subTreeNode=subTreeNode.left;
                    }
                    return subTreeNode;
                }
            }
        //2、当前节点没有右子树
        //2.1为根节点
        if(pNode.next==null){
            return null;
        }

       //2.2不为根节点
        // 找到满足下列要求的第一个祖父节点
        // a.有右子树
        // b.当前节点在此祖父节点的左子树上
        // 返回此祖父节点
         TreeLinkNode B=pNode.next;
         TreeLinkNode A=pNode;

        while(B.right==A){
            if(B.next==null){
                break;
            }
            B=B.next;
        }
     //到了根节点，如果当前节点在根节点右子树上，返回null
        if(B.next==null){
            //到了根节点,当前节点在根节点左子树
            if(B.right==A){
                return null;
            }
        }

    //没到根节点，返回B；或到根节点且当前节点在根节点左子树上，也返回B
            return B;
    }
}
