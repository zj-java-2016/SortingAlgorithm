package com.sunniwell.net;

import org.springframework.boot.system.SystemProperties;

/**
 * @author ：zj
 * @date ：Created in 2020/10/22 9:20
 * @description：快速排序
 * @version: 1.0$
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {0,5,2,1,6,2,6,7,5,4,1,10};
        //int[] arr = Calibrator.generateArr();
        sort(arr, 0, arr.length - 1);
        SelectSort.print(arr);
    }

    public static void sort(int[] arr,int leftPointer, int rightPointer) {
        if(leftPointer >= rightPointer){
            return;
        }
        int benchmark = benchmark(arr, leftPointer, rightPointer);

        //左边
        sort(arr, leftPointer, benchmark - 1);
        //右边
        sort(arr, benchmark + 1 , rightPointer);
    }


    public static int benchmark(int[] arr, int leftPointer, int rightPointer){
        //选择一个基准，将所有数跟该基准进行比较，比小的放到左边，大的放到右边
        //基准
        int datum = arr[rightPointer];
        //开始指针位置
        int left = leftPointer;
        //后边指针开始位置
        int right = rightPointer - 1;

        while (left <= right){
            while (left <= right && arr[left] <= datum){
                left++;
            }
            while (right >= left && arr[right] > datum){
                right--;
            }
            if(left < right){
                SelectSort.swap(arr, left, right);
            }
        }
        SelectSort.swap(arr, left, rightPointer);

        /*SelectSort.print(arr);
        System.out.println();
        System.out.println(left);*/
        return left;
    }
}
