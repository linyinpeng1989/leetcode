import java.util.Arrays;

/**
 * @author Yinpeng.Lin
 * @see <a href="相对名次">https://leetcode-cn.com/problems/relative-ranks/</a>
 * @date Created in 2021/12/1 16:44
 */
public class LeetCode506 {

    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] desc = {"Gold Medal", "Silver Medal", "Bronze Medal"};
        // 声明一个二维数组，用于保存分数与下标对应关系
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = score[i];
            arr[i][1] = i;
        }

        // 二维数组，按照分数进行排序（倒序）
        Arrays.sort(arr, (a, b) -> b[0] - a[0]);

        String[] result = new String[n];
        // 遍历二维数组，填充对应的名词
        for (int i = 0; i < n; i++) {
            int index = arr[i][1];
            if (i >= 3) {
                result[index] = String.valueOf(i + 1);
            } else {
                result[index] = desc[i];
            }
        }
        return result;
    }

}
