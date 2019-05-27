/**
 * @Author: LinK
 * @Date: 2019/5/27 11:14
 */

package com.qhl.leetcode.basestructure;

public class Heap {


    /**
     * 小顶堆的调整过程
     * @param arr
     * @param i
     * @param length
     */
    public static void adjustSamllHeap(int []arr, int i, int length){
        int temp = arr[i];
        for(int k = i*2+1;k<length;k = k*2+1){
            if(k+1<length && arr[k]>arr[k+1]){
                k++;
            }
            if(arr[k] <temp){
                arr[i] = arr[k];
                i = k;
            }else{
                break;
            }
        }
        arr[i] = temp;
    }

    /**
     * 大顶堆的调整过程
     * @param arr
     * @param i
     * @param length
     */
    private static void adjustBigHeap(int []arr, int i, int length){
        int temp = arr[i];
        for(int k = i*2+1;k<length;k = k*2+1){
            if(k+1<length && arr[k]<arr[k+1]){
                k++;
            }
            if(arr[k] >temp){
                arr[i] = arr[k];
                i = k;
            }else{
                break;
            }
        }
        arr[i] = temp;
    }



    public static void main(String[] args) {
        int[] array = {5,4,2,6,9,3,1};
        for (int i = array.length / 2 -1;i >=0;i--){
            adjustSamllHeap(array,i,array.length);
        }

        array[0] =-1;
        adjustSamllHeap(array,0,array.length);
        System.out.println(array[0]);
    }
}
