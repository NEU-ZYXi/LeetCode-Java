
/*

Given an integer array nums, find the contiguous subarray within an array 
(containing at least one number) which has the largest product.

Example 1:
Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:
Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

*/

/*

Solution: use max and min to track the maximum and minimum value currently
          if nums[i]>=0 which means max=max(max*nums[i],nums[i]), min=min(min*nums[i],nums[i])
          otherwise, max=max(min*nums[i],nums[i]), min=min(max*nums[i],nums[i])
O(n),O(1)          

*/

public int maxProduct(int[] nums) {
    if (nums.length == 0) return 0;
    int ans = nums[0], max = nums[0], min = nums[0];
    for (int i = 1; i < nums.length; ++i) {
        if (nums[i] >= 0) {
            max = Math.max(max * nums[i], nums[i]);
            min = Math.min(min * nums[i], nums[i]);
        } else {
            int tmp = max;
            max = Math.max(min * nums[i], nums[i]);
            min = Math.min(tmp * nums[i], nums[i]);
        }
        ans = Math.max(ans, max);
    }
    return ans;
}




