
/*

Given an integer array A, you partition the array into (contiguous) subarrays of length at most K.  
After partitioning, each subarray has their values changed to become the maximum value of that subarray.
Return the largest sum of the given array after partitioning.

Example 1:
Input: A = [1,15,7,9,2,5,10], K = 3
Output: 84
Explanation: A becomes [15,15,15,9,10,10,10]

*/

/*

Solution: dp[i] means the max sum for partitioning A[0...i]
          for each subarray length j, track back to find the max number
          dp[i]=max(max*j+dp[i-j]) which means max sum for A[0...i-j] and A[i-j+1...i] with same max number
O(nk),O(n)          

*/

public int maxSumAfterPartitioning(int[] A, int K) {
    int n = A.length;
    int[] dp = new int[n];
    for (int i = 0; i < n; ++i) {
        int curMax = 0;
        for (int j = 1; j <= K && i >= j - 1; ++j) {
            curMax = Math.max(curMax, A[i - j + 1]);
            dp[i] = Math.max(dp[i], curMax * j + (i >= j ? dp[i - j] : 0));
        }
    }
    return dp[n - 1];
}




