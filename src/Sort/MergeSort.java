package Sort;

import java.util.Arrays;

public class MergeSort {
    public void main(String[] args) {
        int[] array = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        // 只需要修改成对应的方法名就可以了
        mergeSort(array, 0, array.length - 1);

        System.out.println(Arrays.toString(array));
    }

    public void mergeSort(int[] array, int start, int end) {
        if (start < end) {//当子序列中只有一个元素时结束递归
            int mid = (start + end) / 2;//划分子序列
            mergeSort(array, start, mid);//对左侧子序列进行递归排序
            mergeSort(array, mid + 1, end);//对右侧子序列进行递归排序
            merge(array, start, mid, end);//合并
        }
    }

    /**
     * 两路归并算法，两个排好序的子序列合并为一个子序列
     * @param array
     * @param left
     * @param mid
     * @param right
     */
    public void merge(int[] array, int left, int mid, int right) {
        int[] tmp = new int[array.length];//辅助数组
        int p1 = left, p2 = mid + 1, k = left;//p1、p2是检测指针，k是存放指针

        while (p1 <= mid && p2 <= right) {
            if (array[p1] <= array[p2]) {
                tmp[k++] = array[p1++];
            } else {
                tmp[k++] = array[p2++];
            }
        }
        while (p1 <= mid) tmp[k++] = array[p1++];//如果第一个序列未检测完，直接将后面所有元素加到合并的序列中
        while (p2 <= right) tmp[k++] = array[p2++];//同上

        //复制回原数组
        for (int i = 0; i <= right; i++) {
            array[i] = tmp[i];
        }
    }
}
