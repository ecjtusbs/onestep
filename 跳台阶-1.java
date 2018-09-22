/**
 * @Author: chenhaisheng
 * @Date:   2018-09-22T20:44:07+08:00
 * @Email:  ecjtusbs@foxmail.com
 * @Last modified by:   chenhaisheng
 * @Last modified time: 2018-09-22T21:07:09+08:00
 * @Copyright: ecjtusbs@foxmail.com
 */
 题目描述
 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 求该青蛙跳上一个n级的台阶总共有多少种跳法

public class Solution {
    public int JumpFloorII(int target) {

        if (target <0) {
            return -1;
        }

        if (target <= 2) {
            return target;
        }

        int sum=0;
        for (int i = 1; i < target; i++) {
            //累加第一次跳1、2、3、4、……、（target-1)级台阶时总的跳法
            sum += JumpFloorII(target - i);
        }

        //最后加上直接跳n级时的那一种跳法
        return sum+1;
    }
}
