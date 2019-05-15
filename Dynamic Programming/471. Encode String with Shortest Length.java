
/*



*/

/*

Solution 1: dp[i][j] means the encoded string for s[i...j]
            for each length, for each i and j+len, dp[i][j] is s[i...j] if s[i...j] is shorter than 5
            otherwise, try to encode s[i...j] and find the shortest encoded one which is the longest substring as dp[i][j]
            then, for each i<=k<j, dp[i][j]=min(dp[i][k]+dp[k+1][j]) which means we could combine two parts to a shorter string
O(n^4),O(n^2)          

*/

public String encode(String s) {
    int n = s.length();
    String[][] dp = new String[n][n];
    for (int l = 0; l < n; ++l) {
        for (int i = 0; i < n - l; ++i) {
            int j = i + l;
            String cur = s.substring(i, j + 1);
            if (cur.length() < 5) {
                dp[i][j] = cur;
            } else {
                dp[i][j] = cur;
                for (int k = 0; k < cur.length(); ++k) {
                    String tmp = cur.substring(0, k + 1);
                    if (cur.length() % tmp.length() == 0 && cur.replaceAll(tmp, "").length() == 0) {
                        String encode = cur.length() / tmp.length() + "[" + dp[i][i + k] + "]";
                        if (encode.length() < dp[i][j].length()) {
                            dp[i][j] = encode;
                        }
                    }
                }
                for (int k = i; k < j; ++k) {
                    if (dp[i][k].length() + dp[k + 1][j].length() < dp[i][j].length()) {
                        dp[i][j] = dp[i][k] + dp[k + 1][j];
                    }
                }
            }
        }
    }
    return dp[0][n - 1];
}





