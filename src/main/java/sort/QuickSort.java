package sort;

import common.CommonUtil;

/**
 * @author Yinpeng.Lin
 * @desc 快速排序
 * @date Created in 2021/11/30 16:06
 */
public class QuickSort {

    public void sort(int[] arr) {
        partitionSort(arr, 0, arr.length - 1);
    }

    private void partitionSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        // 取中间结点作为中心元素
        int pivotIndex = (low + high) / 2;
        int pivot = arr[pivotIndex];

        // 从两端分别遍历，判断与中间点谁大谁小
        int leftIndex = low;
        int rightIndex = high;
        while (leftIndex < rightIndex) {
            // 左边比中心元素小，同时右边比基准元素大，不做处理并同时改变左右指针
            if (arr[leftIndex] <= pivot && arr[rightIndex] >= pivot) {
                leftIndex++;
                rightIndex--;
                continue;
            }

            // 左边比中间点小，不做处理
            if (arr[leftIndex] <= pivot) {
                leftIndex++;
                continue;
            }

            // 右边比中间点大，不做处理
            if (arr[rightIndex] >= pivot) {
                rightIndex--;
                continue;
            }

            // 交换位置，并移动指针
            int temp = arr[leftIndex];
            arr[leftIndex++] = arr[rightIndex];
            arr[rightIndex--] = temp;
        }

        // 交换中心元素位置
        if (leftIndex == rightIndex) {
            arr[pivotIndex] = arr[leftIndex];
            arr[leftIndex] = pivot;
            // 更新中间元素的下标
            pivotIndex = Math.min(pivotIndex, leftIndex);
        }

        // 左右分区递归处理
        partitionSort(arr, low, pivotIndex);
        partitionSort(arr, pivotIndex + 1, high);
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] arr = new int[] {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        quickSort.sort(arr);
        CommonUtil.printArray(arr);
    }

}
