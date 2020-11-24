package com.sunniwell.net;

/**
 * @author ：zj
 * @date ：Created in 2020/10/20 14:08
 * @description：插入排序
 * @version: 1.0$
 */
public class InsertionSort {

    public static void main(String[] args){
        long time = System.currentTimeMillis();
        int[] arr = Calibrator.generateArr();
        sort(arr);
        SelectSort.print(arr);
        System.out.println();
        System.out.println(System.currentTimeMillis() - time);
    }

    public static void sort(int[] arr){
        for (int i = 1; i < arr.length; i++){
            for (int j = 0; j < i; j++){
                if(arr[i] < arr[j]){
                    int tem = arr[i];
                    for (int k = i; k > j; k--){
                        arr[k] = arr[k - 1];
                    }
                    arr[j] = tem;
                    break;
                }
            }
        }
    }
}
