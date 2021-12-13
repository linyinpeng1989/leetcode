import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * @author Yinpeng.Lin
 * @date Created in 2021/12/6 13:05
 * @see <a href="三数之和">https://leetcode-cn.com/problems/3sum/</a>
 */
public class LeetCode15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        if (length < 3) {
            return result;
        }

        // 将数组从小到大排序
        Arrays.sort(nums);

        // 数组都大于0，或者都小于0时，不符合条件
        if (nums[0] > 0 || nums[length - 1] < 0) {
            return result;
        }

        for (int i = 0; i < length - 2; i++) {

            // nums[i] 与最小2个数之和 > 0，退出循环
            if (nums[i] + nums[i + 1] + nums[i + 2] > 0) {
                break;
            }

            // nums[i]与最大2个数之和 < 0，跳过 nums[i]
            if (nums[i] + nums[length - 1] + nums[length - 2] < 0) {
                continue;
            }

            // 相邻轮次，基准元素大小一致的情况
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int headIndex = i + 1;
            int endIndex = length - 1;
            while (headIndex < endIndex) {
                // 过滤相邻两个元素一致的情况，避免重复
                if (headIndex - 1 > i && nums[headIndex] == nums[headIndex - 1]) {
                    headIndex++;
                    continue;
                }
                if (endIndex + 1 < length && nums[endIndex] == nums[endIndex + 1]) {
                    endIndex--;
                    continue;
                }

                int total = nums[i] + nums[headIndex] + nums[endIndex];
                // 如果结果大于0，则将右边下标左移一个位置
                if (total > 0) {
                    endIndex--;
                }
                // 如果结果小于0，则将左边下标右移一个位置
                else if (total < 0) {
                    headIndex++;
                }
                // 刚好相等的情况，加入结果列表，然后左右下标分别向右、向左移一个位置
                else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[headIndex]);
                    list.add(nums[endIndex]);
                    result.add(list);

                    // 指针位移
                    endIndex--;
                    headIndex++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode15 leetCode15 = new LeetCode15();
        // int[] arr = new int[]{-1, 0, 1, 2, -1, -4};
        int[] arr = new int[]{-2, 0, 0, 2, 2};
        List<List<Integer>> lists = leetCode15.threeSum(arr);
        System.out.println(JSON.toJSONString(lists));
    }

}
