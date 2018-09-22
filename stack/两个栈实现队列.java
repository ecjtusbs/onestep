题目描述
用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。

/**
 * @Author: chenhaisheng
 * @Date:   2018-09-22T16:19:59+08:00
 * @Email:  ecjtusbs@foxmail.com
 * @Last modified by:   chenhaisheng
 * @Last modified time: 2018-09-22T16:46:41+08:00
 * @Copyright: ecjtusbs@foxmail.com
 */


import java.util.Stack;

public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    /**
    *这里采用一种低效的方式实现：stack1模拟队列,stack2stack2作为辅助栈

    *入队列:直接将元素入stack1栈
    *出队列:先将stack1倒序输出到stack2，输出stack2的栈顶元素,再将stack2中剩余元素放回stack1

    *注意：出栈前一定要判断栈是否为空
    */
    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {

        if(stack1.isEmpty()){
            return -1;
        }

        Integer tmp = null;
        //出栈判空,将stack1中元素倒序输出到stack2
        while ((stack1.size()>0) &&(tmp = stack1.pop()) != null) {
            stack2.push(tmp);
        }

        //出栈判空，输出stack2栈顶元素
        if (stack2.size() > 0) {
           // return stack2.pop().intValue();
            int res=stack2.pop().intValue();

            //出栈判空，将剩余元素放回stack1中
            while (stack2.size()>0 &&(tmp = stack2.pop()) != null) {
                stack1.push(tmp);
            }
            //返回
            return res;
        }else{
            return -1;
        }
    }
}
