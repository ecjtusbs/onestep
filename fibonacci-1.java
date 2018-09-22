/**
 * @Author: chenhaisheng
 * @Date:   2018-09-22T19:44:43+08:00
 * @Email:  ecjtusbs@foxmail.com
 * @Last modified by:   chenhaisheng
 * @Last modified time: 2018-09-22T20:09:37+08:00
 * @Copyright: ecjtusbs@foxmail.com
 */
 题目描述
 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项
 （从0开始，第0项为0）。
 n<=39

 public class Solution {
     public int Fibonacci(int n) {

        if (n <= 1) {
             return n;
         }

         int a=0,b=1;
         int res=0;
         //最直观的一种解法，每轮计算下一个fibonacci数
         //注意数列从第零项开始计数
         for (int i = 1; i <n; i++) {
             res=a+b;
             a=b;
             b=res;
         }
        return res;
     }
 }
