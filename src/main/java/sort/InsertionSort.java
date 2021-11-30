package sort;

import common.CommonUtil;

/**
 * @author Yinpeng.Lin
 * @desc 插入排序
 * @date Created in 2021/11/29 14:09
 */
public class InsertionSort {

    public void sort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        // 有序区：初始为第一个元素
        // 无序区：从第二个元素开始
        // 从无序区选择第一个元素，然后倒序遍历有序区，若比该元素大则往后移动一位
        for (int i = 1; i < arr.length; i++) {
            // 当前选择的无序区元素
            int value = arr[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; j--) {
                if (arr[j] > value) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = value;
        }
    }

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        int[] arr = new int[] {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        insertionSort.sort(arr);
        CommonUtil.printArray(arr);
    }

}
