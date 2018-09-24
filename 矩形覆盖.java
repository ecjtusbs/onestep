/**
 * @Author: chenhaisheng
 * @Date:   2018-09-22T21:28:43+08:00
 * @Email:  ecjtusbs@foxmail.com
 * @Last modified by:   chenhaisheng
 * @Last modified time: 2018-09-22T21:28:44+08:00
 * @Copyright: ecjtusbs@foxmail.com
 */
 public class Solution {
    public int RectCover(int target) {

        if (target < 0) {
            return  -1;
        }

        if (target <= 2) {
            return target;
        }

        //第一块竖放时总的放法+第一块横放时总的放法
        return RectCover(target - 1) + RectCover(target - 2);
    }
}
