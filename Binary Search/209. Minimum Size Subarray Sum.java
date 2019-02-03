
/*

Given an array of n positive integers and a positive integer s, 
find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

Example: 
Input: s = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: the subarray [4,3] has the minimal length under the problem constraint.

*/

/*

Solution 1: sliding window
O(n),O(1)

*/

public int minSubArrayLen(int s, int[] nums) {
    if (nums.length == 0) return 0;
    int sum = 0, ans = Integer.MAX_VALUE;
    for (int i = 0, j = 0; j < nums.length; ++j) {
        sum += nums[j];
        while (sum >= s) {
            ans = Math.min(ans, j - i + 1);
            sum -= nums[i++];
        }
    }
    return ans == Integer.MAX_VALUE ? 0 : ans;
}


/*

Solution 2: calculate prefix sums, for each sums[i], use binary search to find the closest sums[i]+s
O(nlogn),O(n)

*/

public int minSubArrayLen(int s, int[] nums) {
    int n = nums.length;
    if (n == 0) return 0;
    int[] sums = new int[n + 1];
    for (int i = 1; i <= n; ++i) sums[i] = sums[i - 1] + nums[i - 1];
    int ans = Integer.MAX_VALUE;
    for (int i = 0; i <= n; ++i) {
        int j = binarySearch(sums, i + 1, n, sums[i] + s);
        if (j == n + 1) break;
        ans = Math.min(ans, j - i);
    }
    return ans == Integer.MAX_VALUE ? 0 : ans;
}

private int binarySearch(int[] sums, int l, int r, int target) {
    while (l <= r) {
        int mid = (l + r) / 2;
        if (sums[mid] >= target) r = mid - 1;
        else l = mid + 1;
    }
    return l;
}



