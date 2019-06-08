
/*

In combinatorial mathematics, a derangement is a permutation of the elements of a set, 
such that no element appears in its original position.
There's originally an array consisting of n integers from 1 to n in ascending order, 
you need to find the number of derangement it can generate.
Also, since the answer may be very large, you should return the output mod 109 + 7.

Example 1:
Input: 3
Output: 2
Explanation: The original array is [1,2,3]. The two derangements are [2,3,1] and [3,1,2].

*/

/*

Solution: dp[i] is the number of derangement for [1...i]
          for ith element, swap it with any previous element to get another derangement, which is (i-1)*dp[i-1]
          if [1...i-1] is not a valid derangement with only one element in wrong position
          then we can swap the one with ith element to get a new derangement, which is (i-1)*dp[i-2]          
O(n),O(n)          

*/

public int findDerangement(int n) {
    if (n <= 1) {
        return 0;
    }
    int MOD = 1000000007;
    long[] dp = new long[n + 1];
    dp[2] = 1;
    for (int i = 3; i <= n; ++i) {
        dp[i] = (i - 1) * (dp[i - 1] + dp[i - 2]) % MOD;
    }
    return (int)dp[n];
}


public int findDerangement(int n) {
    if (n <= 1) {
        return 0;
    }
    int MOD = 1000000007;
    long cur = 1, prev = 0;
    for (int i = 3; i <= n; ++i) {
        long tmp = cur;
        cur = (i - 1) * (cur + prev) % MOD;
        prev = tmp;
    }
    return (int)cur;
}



