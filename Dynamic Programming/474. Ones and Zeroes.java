
/*

In the computer world, use restricted resource you have to generate maximum benefit is what we always want to pursue.
For now, suppose you are a dominator of m 0s and n 1s respectively. 
On the other hand, there is an array with strings consisting of only 0s and 1s.
Now your task is to find the maximum number of strings that you can form with given m 0s and n 1s. 
Each 0 and 1 can be used at most once.
 
Example 1:
Input: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
Output: 4
Explanation: This are totally 4 strings can be formed by the using of 5 0s and 3 1s, which are “10,”0001”,”1”,”0”
 
Example 2:
Input: Array = {"10", "0", "1"}, m = 1, n = 1
Output: 2
Explanation: You could form "10", but then you'd have nothing left. Better form "0" and "1".

*/

/*

Solution: dp[i][j] means the maximum with i zeroes and j ones
          for each string, dp[i][j]=max(dp[i-zero][j-one]+1) if we select the current one to form a larger value
          let i,j loop from the end to avoid overlap and duplicate update previous state
O(nmk),O(nm) where k is the length of strings array          

*/

public int findMaxForm(String[] strs, int m, int n) {
    int[][] dp = new int[m + 1][n + 1];
    for (String s : strs) {
        int zero = 0, one = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                zero++;
            } else {
                one++;
            }
        }
        for (int i = m; i >= zero; --i) {
            for (int j = n; j >= one; --j) {
                dp[i][j] = Math.max(dp[i][j], dp[i - zero][j - one] + 1);
            }
        }
    }
    return dp[m][n];
}





