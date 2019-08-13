
/*

Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value. 
And you need to output the maximum average value.

Example 1:
Input: [1,12,-5,-6,50,3], k = 4
Output: 12.75
Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75

*/

/*

O(n),O(1)

*/

public double findMaxAverage(int[] nums, int k) {
    int n = nums.length;
    double ans = 0, sum = 0;
    for (int i = 0; i < k; ++i) {
        sum += nums[i];
    }
    ans = sum / k;
    for (int i = 0, j = k; j < n; ++i, ++j) {
        sum += nums[j];
        sum -= nums[i];
        ans = Math.max(ans, sum / k);
    }
    return ans;
}




