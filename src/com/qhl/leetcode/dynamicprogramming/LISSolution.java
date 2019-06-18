/**
 * @Author: LinK
 * @Date: 2019/6/18 10:48
 */

package com.qhl.leetcode.dynamicprogramming;

import java.util.Arrays;

/**
 * [3 1 2 6 4 5 10 7]
 */
public class LISSolution {

    public static int solutionNN(int[] sequence){

        if (sequence == null || sequence.length == 0){
            return 0;
        }

        int[] dist = new int[sequence.length];

        for (int i = 0;i<sequence.length;i++){

            dist[i] = 1;

            for (int j =0;j<=i;j++){
                if (sequence[i] > sequence[j] && dist[i] >= dist[j]){
                    dist[i] = dist[j] + 1;
                }
            }
        }

        Arrays.stream(dist).boxed().forEach(integer -> System.out.println(integer));
        return 0;
    }



    public static int solutionNlogN(int[] sequences){
        if (sequences == null || sequences.length==0){
            return 0;
        }

//        store subsequence
        int[] subSeq = new int[sequences.length];

//        final index in subSeq which mean the min value in all subsequence
        int finalIndex = 1;

        subSeq[0] = sequences[0];
        for (int i = 1;i< sequences.length;i++){

            if (sequences[i] > subSeq[finalIndex-1]){
//                add
                subSeq[finalIndex-1] = sequences[i];
                finalIndex++;
            }else if (finalIndex-2 >=0 && sequences[i] < subSeq[finalIndex-1] && sequences[i] > subSeq[finalIndex-2]){
//                replacement
                subSeq[finalIndex-1] = sequences[i];
            }else if (finalIndex == 1 && sequences[i] < subSeq[finalIndex-1]){
                subSeq[finalIndex-1] = sequences[i];
            }
        }

        Arrays.stream(subSeq).boxed().forEach(integer -> System.out.println(integer));
        return 0;

    }
    public static void main(String[] args) {
        int[] sequences = {3,1,2,6,4,5,10,7};

        solutionNlogN(sequences);
    }
}
