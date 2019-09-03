
/*

In a given array nums of positive integers, find three non-overlapping subarrays with maximum sum.
Each subarray will be of size k, and we want to maximize the sum of all 3*k entries.
Return the result as a list of indices representing the starting position of each interval (0-indexed). 
If there are multiple answers, return the lexicographically smallest one.

Example:
Input: [1,2,1,2,6,7,5,1], 2
Output: [0, 3, 5]
Explanation: Subarrays [1, 2], [2, 6], [7, 5] correspond to the starting indices [0, 3, 5].
We could have also taken [2, 1], but an answer of [1, 3, 5] would be lexicographically larger.

*/

/*

Solution: build prefix sums, left[i] means the start index of max left sum, right[i] means the start index of max right sum
          left[i]=left[i-1] if sums[i-k...i] is smaller, otherwise, update left[i]=i-k
          right[i]=right[i+1] if sums[i...i+k] is smaller, otherwise, update right[i]=i
          for each possible index of middle interval [k,n-2*k], find the max of the sum of left, right and sums[i+k]-sums[i]
O(n),O(n)          

*/

public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
    int n = nums.length;
    int[] ans = new int[3];
    int[] sums = new int[n + 1];
    int[] left = new int[n];
    int[] right = new int[n];
    for (int i = 1; i <= n; ++i) {
        sums[i] = sums[i - 1] + nums[i - 1];
    }
    for (int i = k, max = 0; i <= n - 2 * k; ++i) {
        int sum = sums[i] - sums[i - k];
        if (sum > max) {
            max = sum;
            left[i] = i - k;
        } else {
            left[i] = left[i - 1];
        }
    }
    for (int i = n - k, max = 0; i >= 0; --i) {
        int sum = sums[i + k] - sums[i];
        if (sum >= max) {
            max = sum;
            right[i] = i;
        } else {
            right[i] = right[i + 1];
        }
    }
    for (int i = k, max = 0; i <= n - 2 * k; ++i) {
        int l = left[i], r = right[i + k];
        int sum = sums[l + k] - sums[l] + sums[r + k] - sums[r] + sums[i + k] - sums[i];
        if (sum > max) {
            max = sum;
            ans[0] = l;
            ans[1] = i;
            ans[2] = r;
        }
    }
    return ans;
}




