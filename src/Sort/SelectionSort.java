package Sort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] array = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        // 只需要修改成对应的方法名就可以了
        selectionSort(array);

        System.out.println(Arrays.toString(array));
    }

    /**
     *
     * @param array
     */
    public static void selectionSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        int length = array.length;
        for (int i = 0; i <= length; i++) {
            //保存最小数的索引
            int min = i;
            for (int j = i+1; j < length; j++) {
                if (array[j] > array[min]) {
                    min = j;
                }
            }

            if (i != min) {
                swap(array, min, i);
            }
        }
    }

    /**
     * 对象交换
     * @param array
     * @param a
     * @param b
     */
    private static void swap(int[] array, int a, int b){
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
}
