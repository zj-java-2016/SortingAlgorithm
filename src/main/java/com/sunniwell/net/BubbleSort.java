package com.sunniwell.net;

/**
 * @author ：zj
 * @date ：Created in 2020/10/20 10:05
 * @description：冒泡排序
 * @version: 1.0$
 */
public class BubbleSort {

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        int[] arr = Calibrator.generateArr();
        sortOptimizationTwo(arr);
        SelectSort.print(arr);
        System.out.println();
        System.out.println(System.currentTimeMillis() - time);
    }

    public static void sort(int[] arr){
        for (int i = arr.length - 1; i > 0; i--){
            for (int j = 0; j < i; j++){
                if(arr[j] > arr[j + 1]){
                    SelectSort.swap(arr, j, j+1);
                }
            }
        }
    }

    /**
     * 优化第一步
     * @param arr
     */
    public static void sortOptimization(int[] arr){
        for (int i = arr.length - 1; i > 0; i--){
            boolean isSorted = true;
            for (int j = 0; j < i; j++){
                if(arr[j] > arr[j + 1]){
                    SelectSort.swap(arr, j, j+1);
                    isSorted = false;
                }
            }
            if(isSorted){
                break;
            }
        }
    }

    /**
     * 优化第二步，确定排序边界 (在数组中最好的情况一下，排序效率有所提升)
     */
    public static void sortOptimizationTwo(int[] arr){
        //记录最后一次交换的位置
        int lastExchangeIndex = 0;
        int sortBorder = arr.length - 1;
        for (int i = sortBorder; i > 0; i--){
            boolean isSorted = true;
            for (int j = 0; j < i; j++){
                if(arr[j] > arr[j + 1]){
                    SelectSort.swap(arr, j, j+1);
                    isSorted = false;
                    lastExchangeIndex = j;
                }
            }
            sortBorder = lastExchangeIndex;
            if(isSorted){
                break;
            }
        }
    }
}
