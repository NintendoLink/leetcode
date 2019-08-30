/**
 * @Author: LinK
 * @Date: 2019/8/23 9:31
 */

package com.qhl.leetcode.other;

/**
 * 1154. 一年中的第几天
 *
 * 给你一个按 YYYY-MM-DD 格式表示日期的字符串 date，请你计算并返回该日期是当年的第几天。

 通常情况下，我们认为 1 月 1 日是每年的第 1 天，1 月 2 日是每年的第 2 天，依此类推。每个月的天数与现行公元纪年法（格里高利历）一致。

  

 示例 1：

 输入：date = "2019-01-09"
 输出：9
 示例 2：

 输入：date = "2019-02-10"
 输出：41
 示例 3：

 输入：date = "2003-03-01"
 输出：60
 示例 4：

 输入：date = "2004-03-01"
 输出：61
  

 提示：

 date.length == 10
 date[4] == date[7] == '-'，其他的 date[i] 都是数字。
 date 表示的范围从 1900 年 1 月 1 日至 2019 年 12 月 31 日。

 */
public class DayOfYearSolution {

    /**
     * 思路
     * 1、常规算法即可
     * @param date
     * @return
     */
    public static int solution(String date) {
        if (date == null || date.length()==0){
            return 0;
        }

        int res = 0;
        String[] ymd = date.split("-");
        int year = Integer.valueOf(ymd[0]);
        int month = Integer.valueOf(ymd[1]);
        int day = Integer.valueOf(ymd[2]);

        int[] monthDay = new int[11];
        monthDay[0] = 31;
        monthDay[1] = 28;
        monthDay[2] = 31;
        monthDay[3] = 30;
        monthDay[4] = 31;
        monthDay[5] = 30;
        monthDay[6] = 31;
        monthDay[7] = 31;
        monthDay[8] = 30;
        monthDay[9] = 31;
        monthDay[10] = 30;

        for (int i = 0;i< month-1;i++){
            res += monthDay[i];
        }

        if (((year % 4 ==0 && year % 100!=0) || year % 400 ==0)&& month > 2){
            res+=1;
        }
        return res + day;
    }

    private static boolean isLeapYear(int year){
        return (year % 4 ==0 && year % 100!=0) || year % 400 ==0;
    }

    public static void main(String[] args) {
//        String date = "2019-01-09";
//        String date = "2019-01-09";
//        String date = "2019-01-09";
        String date = "2004-03-01";
        solution(date);
    }
}
