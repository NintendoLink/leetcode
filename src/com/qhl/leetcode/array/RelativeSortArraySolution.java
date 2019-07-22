/**
 * @Author: LinK
 * @Date: 2019/7/18 9:22
 */

package com.qhl.leetcode.array;

import java.util.*;


/**
 * 1122. 数组的相对排序
 * 给你两个数组，arr1 和 arr2，

 arr2 中的元素各不相同
 arr2 中的每个元素都出现在 arr1 中
 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。

  

 示例：

 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 输出：[2,2,2,1,4,3,3,9,6,7,19]
  

 提示：

 arr1.length, arr2.length <= 1000
 0 <= arr1[i], arr2[i] <= 1000
 arr2 中的元素 arr2[i] 各不相同
 arr2 中的每个元素 arr2[i] 都出现在 arr1 中

 */
public class RelativeSortArraySolution {
    /**
     * 思路
     * 1、暴力算法
     * 2、暂时未想到巧妙地解法
     * @param arr1
     * @param arr2
     * @return
     */
    public static int[] solution(int[] arr1,int[] arr2){

        Set<Integer> tempSet = new HashSet<>();

//        int[] tempArr = Arrays.copyOfRange(arr1,0,arr1.length);
        int[] res = new int[arr1.length];
        int index = 0;
        for (int i =0;i<arr2.length;i++){
            for (int j =0;j<arr1.length;j++){
                if (arr2[i] == arr1[j]){
                    res[index++] = arr2[i];
                    tempSet.add(arr2[i]);
                }
            }
        }

        List<Integer> arr1List = new ArrayList<>();
        Arrays.stream(arr1).boxed().forEach(integer -> arr1List.add(integer));

        arr1List.removeAll(tempSet);
        int tempIndex = 0;
        int[] tempArray = new int[arr1List.size()];
        for (Integer tailInt : arr1List){
            tempArray[tempIndex++] = tailInt;
        }

        Arrays.sort(tempArray);

        for (int i = 0;i<tempArray.length;i++){
            res[i + index] = tempArray[i];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};

        Arrays.stream(solution(arr1,arr2)).boxed().forEach(integer -> System.out.println(integer));
    }
}
