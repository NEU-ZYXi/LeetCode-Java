
/*

Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

Example 1:
Input: [3,0,1]
Output: 2

Example 2:
Input: [9,6,4,2,3,5,7,0,1]
Output: 8

*/

/*

Solution: since num is 0,1,2,...,n, num^index=0 if this num is not missing
O(n),O(1)

*/

public int missingNumber(int[] nums) {
    int ans = nums.length;
    for (int i = 0; i < nums.length; ++i) ans = ans ^ i ^ nums[i];
    return ans;
}



