import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Yinpeng.Lin
 * @see <a href="合并区间">https://leetcode-cn.com/problems/merge-intervals/</a>
 * @date Created in 2021/12/2 17:26
 */
public class LeetCode56 {

    public int[][] merge(int[][] intervals) {
        // 二维数组按照第一个元素排序（区间的左边界），从小到大
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> result = new ArrayList<>();
        // 初始化左右边界值
        int curLeft = intervals[0][0];
        int curRight = intervals[0][1];
        for (int i = 1; i <= intervals.length; i++) {
            // 数组遍历完毕，将最后一个区间放入结果数组
            if (i == intervals.length) {
                result.add(new int[]{curLeft, curRight});
                continue;
            }

            // 有交集时，更新右边边界值
            if (curRight >= intervals[i][0]) {
                curRight = Math.max(curRight, intervals[i][1]);
                continue;
            }

            // 将一个合并后的区间放入结果集，并更新当前左右边界值
            result.add(new int[]{curLeft, curRight});
            curLeft = intervals[i][0];
            curRight = intervals[i][1];
        }
        return result.toArray(new int[result.size()][2]);
    }

    public static void main(String[] args) {
        LeetCode56 leetCode56 = new LeetCode56();
        int[][] arr = new int[][]{new int[]{1, 3}, new int[]{2, 6}, new int[]{8, 10}, new int[]{15, 18}};
        // int[][] arr = new int[][]{new int[]{1, 4}, new int[]{4, 5}};
        int[][] merge = leetCode56.merge(arr);
        System.out.println(JSON.toJSONString(merge));
    }

}
