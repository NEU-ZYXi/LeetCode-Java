
/*

Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. 
Return the maximum product you can get.

Example 1:
Input: 2
Output: 1
Explanation: 2 = 1 + 1, 1 × 1 = 1.

Example 2:
Input: 10
Output: 36
Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.

*/

/*

Solution 1: for breaking into two parts, the maximum product is (n/2)*(n/2) if n is even or ((n-1)/2)*((n+1)/2) if n is odd
            to make sure the product is larger than n, (n/2)*(n/2)>=n which is n>=4, ((n-1)/2)*((n+1)/2)>=n which is n>=5
            so, when n is 2 or 3, it should not be breaked, and to get maximum, we need to use 3 as many as possible
O(n),O(1)            

*/

public int integerBreak(int n) {
    if (n == 2) return 1;
    if (n == 3) return 2;
    int ans = 1;
    while (n > 4) {
        ans *= 3;
        n -= 3;
    }
    ans *= n;
    return ans;
}


/*

Solution 2: dp[i] means the maximum integer breaked by i
            for each integer j where 1<=j<=i/2, break it or not and find the max for dp[i]
O(n^2),O(n)            

*/

public int integerBreak(int n) {
    int[] dp = new int[n + 1];
    dp[1] = 1;
    for (int i = 2; i <= n; ++i) {
        for (int j = 1; 2 * j <= i; ++j) dp[i] = Math.max(dp[i], Math.max(j, dp[j]) * Math.max(i - j, dp[i - j]));
    }
    return dp[n];
}




