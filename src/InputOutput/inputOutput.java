package InputOutput;

import java.util.Arrays;
import java.util.Scanner;

public class inputOutput {
    Scanner sc = new Scanner(System.in);
    /**
     *以三行输入为例，第一行输入两个数字m，n，分别表示数组num1和num2的长度，第二行和第三行输入num1和num2的元素，以空格分隔。
     * 3 4
     * 10 2 3
     * 11 4 5 6
     * 换成其他数据类型也一样，其他数值类型就修改int跟nextInt就可以了，String就把nextInt()换成next()
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("输入：");
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] num1 = new int[m];
        int[] num2 = new int[n];
        // 换成其他数据类型也一样，其他数值类型就修改int跟nextInt就可以了，
        //String就把nextInt()换成next()
        for(int i = 0; i < m; i ++) {
            num1[i] = sc.nextInt();  // 一个一个读取
        }
        for(int i = 0; i < n; i ++) {
            num2[i] = sc.nextInt();
        }
        System.out.println("输出：");
        System.out.println(Arrays.toString(num1));
        System.out.println(Arrays.toString(num2));
    }
}
