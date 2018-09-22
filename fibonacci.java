/**
 * @Author: chenhaisheng
 * @Date:   2018-09-22T19:44:43+08:00
 * @Email:  ecjtusbs@foxmail.com
 * @Last modified by:   chenhaisheng
 * @Last modified time: 2018-09-22T19:57:22+08:00
 * @Copyright: ecjtusbs@foxmail.com
 */
 题目描述
 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项
 （从0开始，第0项为0）。
 n<=39

 public class Solution {
    public static int Fibonacci(int n) {

        if (n <= 1) {
            return n;
        }

        int a=0,b=1;
            //  n:      0 1      2 3     4 5     6 7
     // Fibonacci(n)    0 1      1 2     3 5     8 13
            //   a b   a1 b1   a2 b2   a3 b3
        // 第一轮a=0;b=1;
        //每一轮构造后面的两个fibonacci数
        // n/2即为总共循环的次数,这里n>=1
        for (int i = 1; i <= n/2; i++) {
            //求接下来的两个fibonacci数
            a+=b;
            b+=a;
        }

        //判断是基数位还是偶数位，偶数位输出a，否则输出b
        // 注意这里是从第零项开始
        if (n % 2 == 0) {
            return a;
        }
        return b;
    }
}
