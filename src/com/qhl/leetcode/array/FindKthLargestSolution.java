/**
 * @Author: LinK
 * @Date: 2019/5/27 11:04
 */

package com.qhl.leetcode.array;

import java.util.Arrays;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

 示例 1:

 输入: [3,2,1,5,6,4] 和 k = 2
 输出: 5
 示例 2:

 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 输出: 4
 */
public class FindKthLargestSolution {

    /**
     * 思路
     * 1、使用堆
     * 2、使用优先队列保存元素
     * @param nums
     * @param k
     * @return
     */
    public static int solution(int[] nums,int k){

        if(nums == null || nums.length ==0 ||
                k > nums.length){
            return 0;
        }

        //思路1
        int[] resHeap = Arrays.copyOfRange(nums,0,k);
        for (int i = resHeap.length/2 -1;i>-1;i--){
            adjustSamllHeap(resHeap,i,resHeap.length);
        }

        for (int i =k;i<nums.length;i++){
            if (nums[i] > resHeap[0]){
                resHeap[0] = nums[i];
                adjustSamllHeap(resHeap,0,resHeap.length);
            }
        }

        return resHeap[0];

        //思路2
//        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1 - o2;
//            }
//        });
//
//        for (int i =0;i<nums.length;i++){
//            if (pq.size() < k){
//                pq.add(nums[i]);
//            }else if (nums[i] > pq.peek()){
//
//                pq.remove();
//                pq.add(nums[i]);
//            }
//        }
//        return pq.poll();
    }




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


    public static void main(String[] args) {

        int[] nums = {3,7,10,1,2,4,9,5,6};
        System.out.println(solution(nums,1));
    }
}
