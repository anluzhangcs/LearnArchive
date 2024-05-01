package demo1;

import java.util.Arrays;


public class ArraysTest {
    public static_test void main(String[] args) {
        int[] arr = {1,2,4,3,5};
        int[] arr1 = {1,3,2,4,5};

        //判断两个数组是否相等
        boolean equals = Arrays.equals(arr,arr1);
        System.out.println(equals);

        //输出数组信息
        System.out.println(Arrays.toString(arr));

        //对数组进行填充,即替换
        Arrays.fill(arr1,10);
        System.out.println(Arrays.toString(arr1));

        //对数组进行排序 默认升序
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        //对数组二分查找 前提是数组已排好序
        //key为查找的值
        //返回值为负数表示没查到
        System.out.println(Arrays.binarySearch(arr, 6));

        String[] str = new String[5];
    }
}
