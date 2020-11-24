package com.sunniwell.net;

/**
 * @author ：zj
 * @date ：Created in 2020/10/21 9:04
 * @description：归并排序
 * @version: 1.0$
 */
public class MergeSort {

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        //int[] arr = {1,12,4,13,8,16,9,7,9,10};
        int[] arr = Calibrator.generateArr();
        sort(arr, 0, arr.length - 1);
        SelectSort.print(arr);
        System.out.println();
        System.out.println(System.currentTimeMillis() - time);
    }

    public static void sort(int[] arr, int leftBound, int rightBound){
        if(leftBound >= rightBound){
            return;
        }
        //获取平均值
        int mid = leftBound + (rightBound - leftBound)/2;
        sort(arr, leftBound, mid);
        sort(arr, mid + 1, rightBound);
        merge1(arr, leftBound, mid + 1, rightBound);
    }

    public static void merge1(int[] arr, int left, int right, int bound){
        int[] temp = new int[bound - left + 1];
        int i = left;
        int j = right;
        int k = 0;
        while (i < right && j <= bound){
            temp[k++] = arr[i] <= arr[j] ? arr[i++]: arr[j++];
        }

        while (i < right){
            temp[k++] = arr[i++];
        }
        while (j <= bound){
            temp[k++] = arr[j++];
        }

        for (int m = 0; m < temp.length; m++){
            arr[left + m] = temp[m];
        }
    }



































    public static void sort(int[] arr){
        recursion(arr, 0, arr.length - 1);
    }

    /**
     *
     * @param arr
     * @param leftBound 数组要排序的左边界
     * @param rightBound 数组要排序的右边界
     */
    public static void recursion(int[] arr, int leftBound, int rightBound){
        if(leftBound >= rightBound){
            return;
        }
        int mid =leftBound + (rightBound - leftBound)/ 2;
        //切成两半   的左半
        recursion(arr,leftBound, mid);
        //切成两半   的右半
        recursion(arr,mid + 1, rightBound);
        merge(arr, leftBound, mid + 1, rightBound);
    }

    /**
     *
     * @param arr
     * @param left 左边数组的开始位置
     * @param right 右边数组的开始位置
     * @param bound 遍历的边界
     */
    public static void merge(int[] arr, int left, int right, int bound){
        //创建一个跟排序等大小临时数组
        int[] temp = new int[bound - left + 1];
        //将数组分成两半
        int i = left;
        int mid = right - 1;
        int j = right;
        //定义三个指针
        int tempStartIndex = 0; //临时数组的开始位置
        while (i <= mid && j <= bound){
            if(arr[i] <= arr[j]){
                temp[tempStartIndex] = arr[i];
                i++;
                tempStartIndex++;
            }else {
                temp[tempStartIndex] = arr[j];
                j++;
                tempStartIndex++;
            }
        }

        //左边没处理完成
        while (i <= mid) {
            temp[tempStartIndex] = arr[i];
            i++;
            tempStartIndex++;
        }

        //右边没处理完成
        while (j <= bound) {
            temp[tempStartIndex] = arr[j];
            j++;
            tempStartIndex++;
        }

        for (int m = 0; m < temp.length; m++){
            arr[left + m] = temp[m];
        }
    }
}
