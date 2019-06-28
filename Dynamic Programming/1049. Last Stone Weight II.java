
/*

We have a collection of rocks, each rock has a positive integer weight.
Each turn, we choose any two rocks and smash them together.  
Suppose the stones have weights x and y with x <= y.  
The result of this smash is:
If x == y, both stones are totally destroyed;
If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
At the end, there is at most 1 stone left.  
Return the smallest possible weight of this stone (the weight is 0 if there are no stones left.)

Example 1:
Input: [2,7,4,1,8,1]
Output: 1
Explanation: 
We can combine 2 and 4 to get 2 so the array converts to [2,7,1,8,1] then,
we can combine 7 and 8 to get 1 so the array converts to [2,1,1,1] then,
we can combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
we can combine 1 and 1 to get 0 so the array converts to [1] then that's the optimal value.

*/

/*

Solution: same as separate into two groups, and find the min difference of two elements in two groups
          dp[i][j] means whether we can get i sum with subset of A[0...j]
          dp[i][j]=dp[i][j-1] or dp[i-stones[j-1]][j-1] which means choose current one or not
O(nm),O(nm)          

*/

public int lastStoneWeightII(int[] stones) {
    int n = stones.length, sum = 0, ans = Integer.MAX_VALUE;
    for (int stone : stones) {
        sum += stone;
    }
    boolean[][] dp = new boolean[sum + 1][n + 1];
    for (int i = 0; i <= n; ++i) {
        dp[0][i] = true;
    }
    for (int i = 1; i <= sum / 2; ++i) {
        for (int j = 1; j <= n; ++j) {
            if (dp[i][j - 1] || (i >= stones[j - 1] && dp[i - stones[j - 1]][j - 1])) {
                dp[i][j] = true;
                ans = Math.min(ans, sum - 2 * i);
            }
        }
    }
    return ans;
}




