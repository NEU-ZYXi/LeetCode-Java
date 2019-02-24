
/*

Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:
Input: [10,9,2,5,3,7,101,18]
Output: 4 
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 

*/

/*

Solution 1: dp[i] means LIS for nums[0...i]
            dp[i]=max(dp[j]+1) for 0<=j<i
O(n^2),O(n)            

*/

public int lengthOfLIS(int[] nums) {
    int n = nums.length, ans = 1;
    if (n == 0) return 0;
    int[] dp = new int[n];
    Arrays.fill(dp, 1);
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < i; ++j) {
            if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
        }
        ans = Math.max(ans, dp[i]);
    }
    return ans;
}


/*

Solution 2: use a tails array to indicate the last element of LIS
            for each number, use binary search to find its position in the current tails array which is in increasing order
            if the number is in the last position, LIS increase by 1
O(nlogn),O(n)            

*/

public int lengthOfLIS(int[] nums) {
    int n = nums.length, ans = 0;
    if (n == 0) return 0;
    int[] tails = new int[n];
    for (int num : nums) {
        int l = 0, r = ans;
        while (l < r) {
            int mid = (l + r) / 2;
            if (tails[mid] < num) l = mid + 1;
            else r = mid;
        }
        tails[l] = num;
        if (l == ans) ans++;
    }
    return ans;
}




