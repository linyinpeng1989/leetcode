/**
 * @author Yinpeng.Lin
 * @see <a href="合并两个有序数组">https://leetcode-cn.com/problems/merge-sorted-array/</a>
 * @date Created in 2021/11/4 10:20
 */
public class LeetCode88 {

    /**
     * 使用两个下标分别访问两个数组并比较，将较小元素放入新建的临时数组，最后遍历完赋值给 nums1
     */
    // public void merge(int[] nums1, int m, int[] nums2, int n) {
    //     int p1 = 0, p2 = 0;
    //     int[] temp = new int[m + n];
    //     int cur;
    //     while (p1 < m || p2 < n) {
    //         // nums1 遍历完时，将 nums2[p2] 赋值给当前元素并继续往后遍历
    //         if (p1 == m) {
    //             cur = nums2[p2++];
    //         }
    //         // nums2 遍历完时，将 nums1[p1] 赋值给当前元素并继续往后遍历
    //         else if (p2 == n) {
    //             cur = nums1[p1++];
    //         }
    //         // 均未遍历完，则判断两个元素大小，较小的赋值给当前元素并继续往后遍历
    //         else if (nums1[p1] <= nums2[p2]) {
    //             cur = nums1[p1++];
    //         } else {
    //             cur = nums2[p2++];
    //         }
    //         temp[p1 + p2 - 1] = cur;
    //     }
    //     for (int i = 0; i < temp.length; i++) {
    //         nums1[i] = temp[i];
    //     }
    // }

    /**
     * 反向遍历，数组元素移动，不用额外创建临时数组
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        int cur;
        while (p1 >= 0 || p2 >= 0) {
            // nums1 遍历完时，将 nums2[p2] 赋值给当前元素并继续往前遍历
            if (p1 < 0) {
                cur = nums2[p2--];
            }
            // nums2 遍历完时，将 nums1[p1] 赋值给当前元素并继续往前遍历
            else if (p2 < 0) {
                cur = nums1[p1--];
            }
            // 均未遍历完，则判断两个元素大小，较大的赋值给当前元素并继续往前遍历
            else if (nums1[p1] <= nums2[p2]) {
                cur = nums2[p2--];
            } else {
                cur = nums1[p1--];
            }
            nums1[p1 + p2 + 2] = cur;
        }
    }

}
