package com.sunniwell.net;

import com.sun.org.apache.xpath.internal.operations.NotEquals;

import java.util.Arrays;
import java.util.Random;

/**
 * @author ：zj
 * @date ：Created in 2020/10/20 9:29
 * @description：排序校准器
 * @version: 1.0$
 */
public class Calibrator {

    public static void main(String[] args) {
        boolean bo = true;
        int[] arr = generateArr();
        int[] arr1 = Arrays.copyOf(arr, arr.length);
        //SelectSort.selectMinPosSort(arr);
        //BubbleSort.sortOptimizationTwo(arr);
        //InsertionSort.sort(arr);
        //MergeSort.sort(arr, 0, arr.length - 1);
        QuickSort.sort(arr, 0, arr.length -1);
        Arrays.sort(arr1);
        for (int i =0; i < arr.length; i++){
            if(arr[i] != arr1[i]){
                bo = false;
                break;
            }
        }
        System.out.println(bo);
    }

    public static int[] generateArr() {
        int[] arr = new int[100001];
        Random random = new Random();
        for (int i = 0; i < 100001; i++){
            arr[i] = random.nextInt(100001);
        }
        return arr;
    }


}
