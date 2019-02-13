
/*

Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n 
that satisfy the condition nums[i] + nums[j] + nums[k] < target.

Example:
Input: nums = [-2,0,1,3], and target = 2
Output: 2 
Explanation: Because there are two triplets which sums are less than 2:
             [-2,0,1]
             [-2,0,3]

*/

/*

O(n^2),O(1)

*/

public int threeSumSmaller(int[] nums, int target) {
    int ans = 0;
    Arrays.sort(nums);
    for (int i = 0; i < nums.length; ++i) {
        int j = i + 1, k = nums.length - 1;
        while (j < k) {
            int sum = nums[i] + nums[j] + nums[k];
            if (sum < target) {
                ans += k - j;
                j++; 
            } else k--;
        }
    }
    return ans;
}



