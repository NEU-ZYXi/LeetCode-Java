
/*

Given an array A of integers, return the length of the longest arithmetic subsequence in A.
Recall that a subsequence of A is a list A[i_1], A[i_2], ..., A[i_k] with 0 <= i_1 < i_2 < ... < i_k <= A.length - 1, 
and that a sequence B is arithmetic if B[i+1] - B[i] are all the same value (for 0 <= i < B.length - 1).

Example 1:
Input: [3,6,9,12]
Output: 4
Explanation: 
The whole array is an arithmetic sequence with steps of length = 3.

Example 2:
Input: [9,4,7,2,10]
Output: 3
Explanation: 
The longest arithmetic subsequence is [4,7,10].

Example 3:
Input: [20,1,15,3,10,5,8]
Output: 4
Explanation: 
The longest arithmetic subsequence is [20,15,10,5].

*/

/*

Solution: dp[dist][i] means the max length of sequence of dist for A[0...i]
          for 0<=i<j, dist=A[j]-A[i], dp[dist][j]=max(dp[dist][i]+1)
O(nm),O(nm) where n is length of A and m is max distance of two elements in A          

*/

public int longestArithSeqLength(int[] A) {
    int ans = 2, n = A.length;
    Map<Integer, Integer>[] dp = new HashMap[n];
    for (int j = 0; j < n; ++j) {
        dp[j] = new HashMap<>();
        for (int i = 0; i < j; ++i) {
            int dist = A[j] - A[i];
            dp[j].put(dist, dp[i].getOrDefault(dist, 1) + 1);
            ans = Math.max(ans, dp[j].get(dist));
        }
    }
    return ans;
}




