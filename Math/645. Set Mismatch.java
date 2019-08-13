
/*

The set S originally contains numbers from 1 to n. 
But unfortunately, due to the data error, one of the numbers in the set got duplicated to another number in the set, 
which results in repetition of one number and loss of another number.
Given an array nums representing the data status of this set after the error.
Your task is to firstly find the number occurs twice and then find the number that is missing. 
Return them in the form of an array.

Example 1:
Input: nums = [1,2,2,4]
Output: [2,3]

*/

/*

O(n),O(1)

*/

public int[] findErrorNums(int[] nums) {
    int n = nums.length;
    int[] ans = new int[2];
    for (int i = 0; i < n; ++i) {
        int val = Math.abs(nums[i]);
        if (nums[val - 1] < 0) {
            ans[0] = val;
        } else {
            nums[val - 1] *= -1;
        }
    }
    for (int i = 0; i < n; ++i) {
        if (nums[i] > 0) {
            ans[1] = i + 1;
        }
    }
    return ans;
}




