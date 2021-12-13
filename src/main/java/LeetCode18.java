import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Yinpeng.Lin
 * @date Created in 2021/12/6 13:05
 * @see <a href="四数之和">https://leetcode-cn.com/problems/4sum/</a>
 */
public class LeetCode18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        if (length < 4) {
            return result;
        }
        // 从小到大排序
        Arrays.sort(nums);

        // 需要4个元素，所以 i < length -3
        for (int i = 0; i < length - 3; i++) {

            // nums[i]与最小的3个元素之和大于target，则直接结束循环
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }

            // 如果 nums[i] 与最大3个元素之和小于 target，则跳过 nums[i] 继续病例
            if ((long) nums[i] + nums[length - 1] + nums[length - 2] + nums[length - 3] < target) {
                continue;
            }


            // 相邻元素相同时，为了避免重复，直接跳过
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 需要3个元素，所以 j < length - 2
            for (int j = i + 1; j < length - 2; j++) {

                // nums[i]、nums[j]与最小2个元素之和大于target，则退出该循环
                // 避免几个 int 值相加超出 int 数值范围导致负数结果，将 nums[i] 转换为 long
                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }

                // nums[i]、nums[j]与最大2个元素之和小于target，跳过继续遍历
                if ((long) nums[i] + nums[j] + nums[length - 1] + nums[length - 2] < target) {
                    continue;
                }

                // 相邻元素相同时，为了避免重复，直接跳过
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                // 定义前后两个下标
                int headIndex = j + 1;
                int endIndex = length - 1;
                while (headIndex < endIndex) {
                    // 相邻元素相同时，为了避免重复，直接跳过
                    if (headIndex > j + 1 && nums[headIndex] == nums[headIndex - 1]) {
                        headIndex++;
                        continue;
                    }

                    if (endIndex + 1 < length && nums[endIndex] == nums[endIndex + 1]) {
                        endIndex--;
                        continue;
                    }

                    int diff = nums[i] + nums[j] + nums[headIndex] + nums[endIndex] - target;
                    if (diff > 0) {
                        endIndex--;
                    } else if (diff < 0) {
                        headIndex++;
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[headIndex]);
                        list.add(nums[endIndex]);
                        result.add(list);

                        // 下标位移
                        headIndex++;
                        endIndex--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode18 leetCode18 = new LeetCode18();
        // int[] arr = new int[]{2, 2, 2, 2, 2};
        // int[] arr = new int[]{1, 0, -1, 0, -2, 2};
        int[] arr = new int[]{0,0,0,1000000000,1000000000,1000000000,1000000000};
        // int[] arr = new int[]{1, -2, -5, -4, -3, 3, 3, 5};
        List<List<Integer>> lists = leetCode18.fourSum(arr, 1000000000);
        System.out.println(JSON.toJSONString(lists));
    }

}
