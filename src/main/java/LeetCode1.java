import java.util.HashMap;
import java.util.Map;

/**
 * @author Yinpeng.Lin
 * @see <a href="两数之和">https://leetcode-cn.com/problems/two-sum/</a>
 * @date Created in 2021/10/27 10:13
 */
public class LeetCode1 {

    // 双重循环 耗时 114ms
    // public int[] twoSum(int[] nums, int target) {
    //     int[] result = new int[2];
    //     for (int i = 0; i < nums.length; i++) {
    //         for (int j = 0; j < nums.length; j++) {
    //             if (i == j) {
    //                 continue;
    //             }
    //             if (nums[i] + nums[j] == target) {
    //                 result[0] = i;
    //                 result[1] = j;
    //                 return result;
    //             }
    //         }
    //     }
    //     return result;
    // }

    // 利用哈希表，耗时 2ms
    public int[] twoSum(int[] nums, int target) {
        // 缓存 nums 元素及其对应的下标
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 计算差值，若差值在 map 中已经存在，即满足条件返回
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        LeetCode1 leetCode = new LeetCode1();
        int[] nums = new int[] {3,3};
        int[] result = leetCode.twoSum(nums, 6);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

}
