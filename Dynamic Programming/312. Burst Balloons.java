
/*

Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. 
You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. 
Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.
Find the maximum coins you can collect by bursting the balloons wisely.

Note:
You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100

Example:
Input: [3,1,5,8]
Output: 167 
Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
             coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167

*/

/*

Solution: 1. build a new array with two '1' in both ends of original array to avoid corner case check
          2. dp[i][j] means the maximum value we can get when we burst all the balloons of arr[i+1...j-1]
             the final state is dp[0][n-1] which means the result of bursting all of arr[1...n-2] which is nums[0...n-1]
          3. for each k in [i+1...j-1] which means the last balloon we burst, we have transition equation
             dp[i][j]=max(arr[i]*arr[k]*arr[j]+dp[i][k]+dp[k][j])
             arr[i]*arr[k]*arr[j] means since arr[k] is the last one, it has value of multiplication with arr[i] and arr[j]
             dp[i][k] means the maximum value we can get for arr[i+1...k-1]
             dp[k][j] means the maximum value we can get for arr[k+1...j-1]
             so these three parts form the whole dp[i][j], which is the maximum value we can get for arr[i+1...j-1]
O(n^3),O(n^2)             

*/

public int maxCoins(int[] nums) {
    int[] arr = new int[nums.length + 2];
    int n = arr.length;
    arr[0] = arr[n - 1] = 1;
    for (int i = 1; i < n - 1; ++i) arr[i] = nums[i - 1];
    int[][] dp = new int[n][n];
    for (int len = 2; len < n; ++len) {
        for (int i = 0; i < n - len; ++i) {
            int j = i + len;
            for (int k = i + 1; k < j; ++k) dp[i][j] = Math.max(dp[i][j], arr[i] * arr[k] * arr[j] + dp[i][k] + dp[k][j]);
        }
    }
    return dp[0][n - 1];
}




