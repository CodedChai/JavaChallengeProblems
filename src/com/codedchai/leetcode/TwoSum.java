package com.codedchai.leetcode;

public class TwoSum {

    public static void main(String[] args){
        TwoSum solution = new TwoSum();

        int[] nums = new int[]{2, 7, 11, 15};
        int target = 0;

        System.out.println(solution.twoSum(nums, target));

    }

    // This is my solution
    public int[] twoSum(int[] nums, int target){
        int[] answer = new int[2];
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                if((target - nums[i] - nums[j]) == 0){
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }
        return answer;

    }

}
