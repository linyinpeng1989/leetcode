/**
 * @author Yinpeng.Lin
 * @date Created in 2021/12/1 16:44
 * @see <a href="搜索旋转排序数组">https://leetcode-cn.com/problems/search-in-rotated-sorted-array/</a>
 */
public class LeetCode33 {

    /**
     * 将数组从中间分开成左右两部分的时候，一定有一部分的数组是有序的。我们可以在常规二分查找的时候查看当前 mid 为分割位置分割出来的两个部分 [l, mid] 和 [mid + 1, r] 哪个部分是有序的，
     * 并根据有序的那个部分确定我们该如何改变二分查找的上下界，因为我们能够根据有序的那部分判断出 target 在不在这个部分。
     *
     * @param nums   有序数组，在某个下标 k 上进行了旋转。[0,1,2,4,5,6,7] -> [4,5,6,7,0,1,2]，k=3
     * @param target 目标值
     * @return
     */
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }

        // mid = (nums.length - 1) / 2
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] == target) {
                return mid;
            }
            // 表示 [0, mid - 1] 是有序的子数组
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            // 表示 0 - mid 有部分是有序的，比如 [4,5,6,7,0,1]，即 [mid + 1, n - 1]是有序子数组
            else {
                if (nums[mid] < target && target <= nums[n-1]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        LeetCode33 leetCode33 = new LeetCode33();
        int[] arr = new int[]{1,3,5};
        System.out.println(leetCode33.search(arr, 3));
    }

}
