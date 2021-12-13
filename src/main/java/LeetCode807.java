/**
 * @author Yinpeng.Lin
 * @see <a href="保持城市天际线">https://leetcode-cn.com/problems/max-increase-to-keep-city-skyline/</a>
 * @date Created in 2021/12/13 15:34
 */
public class LeetCode807 {

    /**
     * 取纵向各列最大值组成一个一维数组，取横向各行最大值组成一个一维数组，然后交叉取各个节点最小取值
     *
     * @param grid
     * @return
     */
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        // 纵向每一列取最大值组成数组
        int[] vertical = new int[grid[0].length];
        for (int i = 0; i < grid[0].length; i++) {
            int max = 0;
            for (int j = 0; j < grid.length; j++) {
                max = Math.max(max, grid[j][i]);
            }
            vertical[i] = max;
        }

        // 横向每一行取最大值组成数组
        int[] horizontal = new int[grid.length];
        for (int i = 0; i < grid.length; i++) {
            int max = 0;
            for (int j = 0; j < grid[0].length; j++) {
                max = Math.max(max, grid[i][j]);
            }
            horizontal[i] = max;
        }

        int diff = 0;
        for (int i = 0; i < vertical.length; i++) {
            for (int j = 0; j < horizontal.length; j++) {
                int min_j_i = Math.min(horizontal[j], vertical[i]);
                diff += Math.max(min_j_i - grid[j][i], 0);
            }
        }
        return diff;
    }


}
