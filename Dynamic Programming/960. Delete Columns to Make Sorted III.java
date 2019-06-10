
/*

We are given an array A of N lowercase letter strings, all of the same length.
Now, we may choose any set of deletion indices, and for each string, we delete all the characters in those indices.
For example, if we have an array A = ["babca","bbazb"] and deletion indices {0, 1, 4}, 
then the final array after deletions is ["bc","az"].
Suppose we chose a set of deletion indices D such that after deletions, 
the final array has every element (row) in lexicographic order.
For clarity, A[0] is in lexicographic order (ie. A[0][0] <= A[0][1] <= ... <= A[0][A[0].length - 1]), 
A[1] is in lexicographic order (ie. A[1][0] <= A[1][1] <= ... <= A[1][A[1].length - 1]), and so on.
Return the minimum possible value of D.length.

Example 1:
Input: ["babca","bbazb"]
Output: 3
Explanation: After deleting columns 0, 1, and 4, the final array is A = ["bc", "az"].
Both these rows are individually in lexicographic order (ie. A[0][0] <= A[0][1] and A[1][0] <= A[1][1]).
Note that A[0] > A[1] - the array A isn't necessarily in lexicographic order.

Example 2:
Input: ["edcba"]
Output: 4
Explanation: If we delete less than 4 columns, the only row won't be lexicographically sorted.

Example 3:
Input: ["ghi","def","abc"]
Output: 0
Explanation: All rows are already lexicographically sorted.

*/

/*

Solution: find the longest increasing subsequence for all strings, check each index, if valid then increase the length of LIS
O(nm^2),O(m) where n is length of A and m is length of strings

*/

public int minDeletionSize(String[] A) {
    int n = A.length, m = A[0].length(), ans = Integer.MAX_VALUE;
    int[] dp = new int[m];
    Arrays.fill(dp, 1);
    for (int i = 0; i < m; ++i) {
        for (int j = 0; j < i; ++j) {
            int k = 0;
            for (k = 0; k < n; ++k) {
                if (A[k].charAt(j) > A[k].charAt(i)) {
                    break;
                }
            }
            if (k == n) {
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        ans = Math.min(ans, m - dp[i]);
    }
    return ans;
}




