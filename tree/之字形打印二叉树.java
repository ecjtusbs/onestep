/**
 * @Author: chenhaisheng
 * @Date:   2018-09-29T20:49:22+08:00
 * @Email:  ecjtusbs@foxmail.com
 * @Last modified by:   chenhaisheng
 * @Last modified time: 2018-09-29T21:04:21+08:00
 * @Copyright: ecjtusbs@foxmail.com
 */

 题目描述
 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。

 解析：
 维护两个栈，A和B
 初始化：将root压入栈A;
 当（A不空或B不空）{
     A栈每个元素依次出栈,打印此元素,并将其左右子节点入栈到B
     B栈每个元素依次出栈,打印此元素,并将其右左子节点入栈到A
 }


import java.util.ArrayList;
import java.util.Stack;

/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}
*/
public class Solution {
    //方法的返回类型为ArrayList<ArrayList<Integer>>型,为题目指定
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {

        ArrayList<ArrayList<Integer>> resArr = new ArrayList();
        //直接借助java体系的stack类
        Stack<TreeNode> s1 = new Stack();
        Stack<TreeNode> s2 = new Stack();
        if(pRoot==null){
            return resArr;
        }
        s1.push(pRoot);

        //终止的条件是两个栈全为空，说明全部处理完成
        while (s1.size() != 0 || s2.size() != 0) {
            //s1每个出栈元素,先压左节点到B,再压右节点到B,具体看题目要求
            ArrayList<Integer> tmpA = new ArrayList<>();

            while (s1.size() != 0) {
                TreeNode top = s1.pop();
                tmpA.add(top.val);

                //左右子节点入B栈
                 if (top.left != null) {
                    s2.push(top.left);
                }
                if (top.right != null) {
                    s2.push(top.right);
                }
            }
            //加入到resArr之前一定要判断是否为空
            if(tmpA.size()>0){
                 resArr.add(tmpA);
            }

            //压入顺序与A相反
            ArrayList<Integer> tmpB = new ArrayList<>();
            while (s2.size() != 0) {
                TreeNode top = s2.pop();
                tmpB.add(top.val);

                if (top.right != null) {
                    s1.push(top.right);
                }
                if (top.left != null) {
                    s1.push(top.left);
                }
            }
            //加入到resArr之前一定要判断是否为空
            if(tmpB.size()>0){
                 resArr.add(tmpB);
            }
        }
        return resArr;
    }
}
