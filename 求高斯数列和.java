/**
 * @Author: chenhaisheng
 * @Date:   2018-09-29T18:08:53+08:00
 * @Email:  ecjtusbs@foxmail.com
 * @Last modified by:   chenhaisheng
 * @Last modified time: 2018-09-29T18:25:47+08:00
 * @Copyright: ecjtusbs@foxmail.com
 */

 题目描述
 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。


解析：借助&&操作，间接实现if() then{}
 public class Solution {
     public int Sum_Solution(int n) {
          /**对比常规实现，题目的主要限制不能直接用if或三元运算符判断逻辑条件
          *可借助&&操作简介实现
          *A&&B的逻辑是：A表达式为真时，才进行B表达式的判断
          */

         /** n!=0时，执行n+=Sum_Solution;n为0时，短路，不执行n+=Sum_Solution;
         *java里不能自动实现int向boolean的转化，所以需要借助！=来对应true和false的情况
         */
         boolean res= ((n!=0)&&((n+=Sum_Solution(n-1))!=0));
         return n;
     }
 }

 public class Solution {
     public int Sum_Solution(int n) {
         return n==0?n:Sum_Solution(n-1);
     }
 }
