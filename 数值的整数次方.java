/**
 * @Author: chenhaisheng
 * @Date:   2018-09-22T21:43:46+08:00
 * @Email:  ecjtusbs@foxmail.com
 * @Last modified by:   chenhaisheng
 * @Last modified time: 2018-09-22T21:45:26+08:00
 * @Copyright: ecjtusbs@foxmail.com
 */
 题目描述
 给定一个double类型的浮点数base和int类型的整数exponent。
 求base的exponent次方。

 // 最基本的求法
 public class Solution {
    public double Power(double base, int exponent) {

        if (exponent == 0) {
            return 1.0;
        }

        if (base == 0.0) {
            return 0.0;
        }

        double res = 1.0;
        for (int i = 0; i < Math.abs(exponent); ++i) {
            res = res * base;
        }

        return exponent<0?1.0/res:res;
    }
}
