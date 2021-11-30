package sort;

import common.CommonUtil;

/**
 * @author Yinpeng.Lin
 * @desc 选择排序
 * @date Created in 2021/11/29 15:21
 */
public class SelectSort {

    public void sort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }

        // 遍历
        for (int i = 0; i < arr.length; i++) {
            // 从 i 开始查找最小值，找到后与 arr[i] 调换位置
            int minimum = arr[i];
            int minimumIndex = i;
            // 遍历后续数组，查询最小值及其下标
            for (int j = i + 1; j < arr.length; j++) {
                if (minimum > arr[j]) {
                    minimum = arr[j];
                    minimumIndex = j;
                }
            }
            // 交换位置
            int temp = arr[i];
            arr[i] = minimum;
            arr[minimumIndex] = temp;
        }
    }

    public static void main(String[] args) {
        SelectSort selectSort = new SelectSort();
        int[] arr = new int[] {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        selectSort.sort(arr);
        CommonUtil.printArray(arr);
    }

}
