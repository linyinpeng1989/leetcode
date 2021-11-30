package sort;

import common.CommonUtil;

/**
 * @author Yinpeng.Lin
 * @desc 归并排序
 * @date Created in 2021/11/30 10:18
 */
public class MergeSort {

    public void sort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private void mergeSort(int[] arr, int low, int high) {
        // 递归结束条件
        if (low >= high) {
            return;
        }
        // 计算中间结点，作为分隔临界值
        int mid = (low + high) / 2;
        // 左边部分进行排序
        mergeSort(arr, low, mid);
        // 右边部分进行排序
        mergeSort(arr, mid + 1, high);
        // 结果归并
        merge(arr, low, high);
    }

    /**
     * 合并排序结果
     *
     * @param arr  数组
     * @param low  低位
     * @param high 高位
     */
    private void merge(int[] arr, int low, int high) {
        // 计算中间结点，作为分隔临界值
        int mid = (low + high) / 2;

        // 初始化两个游标，进行两个有序数组合并
        int arrIndex1 = low;
        int arrIndex2 = mid + 1;

        // 创建临时数组，用于临时存放结果
        int[] temp = new int[arr.length];
        int tempIndex = low;
        while (arrIndex1 <= mid || arrIndex2 <= high) {
            // 前半段数组遍历完毕，直接取 arrIndex2 数组元素
            if (arrIndex1 > mid) {
                temp[tempIndex++] = arr[arrIndex2++];
            }
            // 后半段数组遍历完毕，直接取 arrIndex1 数组元素
            else if (arrIndex2 > high) {
                temp[tempIndex++] = arr[arrIndex1++];
            } else if (arr[arrIndex1] <= arr[arrIndex2]) {
                temp[tempIndex++] = arr[arrIndex1++];
            } else {
                temp[tempIndex++] = arr[arrIndex2++];
            }
        }

        // 将数组拷贝到原数组
        for (int i = low; i <= high; i++) {
            arr[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] arr = new int[] {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        mergeSort.sort(arr);
        CommonUtil.printArray(arr);
    }

}
