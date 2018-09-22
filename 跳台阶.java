/**
 * @Author: chenhaisheng
 * @Date:   2018-09-22T20:44:07+08:00
 * @Email:  ecjtusbs@foxmail.com
 * @Last modified by:   chenhaisheng
 * @Last modified time: 2018-09-22T20:46:44+08:00
 * @Copyright: ecjtusbs@foxmail.com
 */
 题目描述
 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）
 
 public class Solution {
     public int JumpFloor(int target) {

         if (target <=0) {
             return 0;
         }

         if (target == 1) {
             return 1;
         }
         if (target == 2) {
             return 2;
         }

         //第一步跳一级时总的跳法    +    第一步跳二级时总的跳法
         return JumpFloor(target - 1) + JumpFloor(target - 2);
     }
 }
