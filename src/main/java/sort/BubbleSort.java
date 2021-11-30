package sort;

import common.CommonUtil;

/**
 * @author Yinpeng.Lin
 * @desc 冒泡排序
 * @date Created in 2021/11/29 13:27
 */
public class BubbleSort {

    public void sort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }

        // 进行 N 轮冒泡
        for (int i = 0; i < arr.length; i++) {
            boolean swapFlag = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                // 如果 arr[j] 比 arr[j+1] 大，则交换位置
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    swapFlag = true;
                }
            }
            // 如果当前轮次没有交换位置，表示数组已经有序，结束冒泡排序
            if (!swapFlag) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] arr = new int[] {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        bubbleSort.sort(arr);
        CommonUtil.printArray(arr);
    }

}
