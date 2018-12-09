
/*

Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. 
Return the sum of the three integers. You may assume that each input would have exactly one solution.

Example:
Given array nums = [-1, 2, 1, -4], and target = 1.
The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

*/

/*

O(n^2),O(1)

*/

public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int ans = nums[0] + nums[1] + nums[2];
    for (int i = 0; i < nums.length - 2; ++i) {
        if (i > 0 && nums[i] == nums[i - 1])
            continue;
        int j = i + 1, k = nums.length - 1;
        while (j < k) {
            int sum = nums[i] + nums[j] + nums[k];
            if (Math.abs(sum - target) < Math.abs(ans - target)) 
                ans = sum;
            if (sum > target) {
                k--;
                while (j < k && nums[k] == nums[k + 1]) k--;
            } else {
                j++;
                while (j < k && nums[j] == nums[j - 1]) j++;
            }
        }
    }
    return ans;
}




