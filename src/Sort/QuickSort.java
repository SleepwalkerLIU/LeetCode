package Sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] array = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        // 只需要修改成对应的方法名就可以了
        quickSort(array, 0, array.length - 1);

        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] array, int left, int right){
        if (array == null || left >= right || array.length <= 1) {
            return;
        }
        // 找寻基准数据的正确索引
        int mid = partition(array,left,right);
        quickSort(array, left, mid);
        quickSort(array, mid + 1, right);
    }

    private static int partition(int[] array, int left, int right) {
        // 基准数据
        int tmp = array[left];
        while (right > left) {
            // 当队尾的元素大于等于基准数据时,向前挪动right指针
            while (left < right && array[right] >= tmp) {
                right--;
            }
            // 如果队尾元素小于tmp了,需要将其赋值给left
            array[left] = array[right];

            // 当队首元素小于等于tmp时,向前挪动left指针
            while (left < right && array[left] <= tmp) {
                left++;
            }
            // 当队首元素大于tmp时,需要将其赋值给right
            array[right] = array[left];
        }

        // 跳出循环时left和right相等,此时的left或right就是tmp的正确索引位置
        // 由原理部分可以很清楚的知道left位置的值并不是tmp,所以需要将tmp赋值给arr[left]
        array[left] = tmp;
        return left;// 返回tmp的正确位置
    }
}
