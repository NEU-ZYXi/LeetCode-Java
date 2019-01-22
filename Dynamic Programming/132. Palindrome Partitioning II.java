
/*

Given a string s, partition s such that every substring of the partition is a palindrome.
Return the minimum cuts needed for a palindrome partitioning of s.

Example:
Input: "aab"
Output: 1
Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.

*/

/*

Solution 1: dp[j][i] means whether s[j...i] is palindrome
            ans[i] means the minimum cut for s[0...i]
            ans[i]=min(ans[j-1]+1) for each 0<=j<=i, if s[j...i] is palindrome so that we could trigger one more cut
O(n^2),O(n^2)            

*/

public int minCut(String s) {
    int n = s.length();
    boolean[][] dp = new boolean[n][n];
    int[] ans = new int[n];
    for (int i = 0; i < n; ++i) {
        int min = Integer.MAX_VALUE;
        for (int j = i; j >= 0; --j) {
            if (s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[j + 1][i - 1])) {
                dp[j][i] = true;
                min = j == 0 ? 0 : Math.min(min, ans[j - 1] + 1);
            }
        }
        ans[i] = min;
    }
    return ans[n - 1];
}


/*

Solution 2: dp[i] means the minimum cut for s[0...i]
            don't need to maintain a 2D array for whether s[j...i] is palindrome, for each i, expand to both sides to check
            1. odd length palindrome: 
               for each j where i-j>=0 and i+j<n, s[i-j]=s[i+j] means s[i-j...i+j] is palindrome
               dp[i+j]=min(dp[i-j-1]+1) to trigger one more cut so that s[i-j...i+j] is palindrome
            2. even length palindrome:
               for each j where i-j>=0 and i+j+1<n, s[i-j]=s[i+j+1] means s[i-j...i+j+1] is palindrome
               dp[i+j+1]=min(dp[i-j-1]+1) to trigger one more cut so that s[i-j...i+j+1] is palindrome
O(n^2),O(n)               

*/

public int minCut(String s) {
    int n = s.length();
    int[] dp = new int[n];
    Arrays.fill(dp, Integer.MAX_VALUE);
    for (int i = 0; i < n; ++i) {
        for (int j = 0; i - j >= 0 && i + j < n && s.charAt(i - j) == s.charAt(i + j); ++j) 
            dp[i + j] = i - j == 0 ? 0 : Math.min(dp[i + j], dp[i - j - 1] + 1);
        for (int j = 0; i - j >= 0 && i + j + 1 < n && s.charAt(i - j) == s.charAt(i + j + 1); ++j)
            dp[i + j + 1] = i - j == 0 ? 0 : Math.min(dp[i + j + 1], dp[i - j - 1] + 1); 
    }
    return dp[n - 1];
}




