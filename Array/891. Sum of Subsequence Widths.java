
/*

Given an array of integers A, consider all non-empty subsequences of A.
For any sequence S, let the width of S be the difference between the maximum and minimum element of S.
Return the sum of the widths of all subsequences of A. 
As the answer may be very large, return the answer modulo 10^9 + 7.

Example 1:
Input: [2,1,3]
Output: 6
Explanation:
Subsequences are [1], [2], [3], [2,1], [2,3], [1,3], [2,1,3].
The corresponding widths are 0, 0, 0, 1, 1, 2, 2.
The sum of these widths is 6.

*/

/*

Solution: sort the array since the order doesn't matter
          for A[i], if it's max of current subsequence, there are 2^i such subsequences
          if it's min of current subsequence, there are 2^(n-i-1) such subsequences
          accumulate positive and negative effects of all elements
          to avoid long number overflow, A[i]*2^(n-i-1) is equal to A[n-i-1]*2^i by reversed order
O(nlogn),O(1)          

*/

public int sumSubseqWidths(int[] A) {
    Arrays.sort(A);
    int n = A.length, MOD = 1000000007;
    long ans = 0, cnt = 1;
    for (int i = 0; i < n; ++i) {
        ans = (ans + A[i] * cnt - A[n - i - 1] * cnt) % MOD;
        cnt = (cnt * 2) % MOD;
    }
    return (int)(ans + MOD) % MOD;
}




