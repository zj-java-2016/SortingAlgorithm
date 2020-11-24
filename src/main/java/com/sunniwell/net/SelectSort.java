package com.sunniwell.net;

/**
 * @author ：zj
 * @date ：Created in 2020/10/19 9:18
 * @description：选择排序
 * @version: 1.0$
 */
public class SelectSort {

    public static void main(String[] args){
        long time = System.currentTimeMillis();
        int[] arr = Calibrator.generateArr();
        //selectMinPosSort(arr);
        selectMaxPosAndMinPosSort(arr);
        print(arr);
        System.out.println();
        System.out.println(System.currentTimeMillis() - time);
    }

    public static void selectMaxPosAndMinPosSort(int[] arr){
        for (int i = 0; i < arr.length >> 1; i++){
            int minPos = i;
            int maxPos = arr.length - i -1;
            if(arr[minPos] > arr[maxPos]){
                swap(arr, minPos, maxPos);
            }
            for (int j = i + 1; j < arr.length - i; j++){
                minPos = arr[minPos] > arr[j] ? j : minPos;
                maxPos = arr[maxPos] > arr[j] ? maxPos : j;
            }
            swap(arr, i, minPos);
            swap(arr, arr.length - i -1, maxPos);
        }
    }

    public static void selectMinPosSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++){
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++){
                minPos = arr[minPos] < arr[j] ? minPos : j;
            }
            swap(arr, i, minPos);
        }
    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void print(int[] arr){
        for (int k : arr){
            System.out.print(k + " ");
        }
    }
}
