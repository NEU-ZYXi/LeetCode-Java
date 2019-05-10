
/*

Given an array A of strings, find any smallest string that contains each string in A as a substring.
We may assume that no string in A is substring of another string in A.
Note:
1 <= A.length <= 12
1 <= A[i].length <= 20

Example 1:
Input: ["alex","loves","leetcode"]
Output: "alexlovesleetcode"
Explanation: All permutations of "alex","loves","leetcode" would also be accepted.

Example 2:
Input: ["catg","ctaagt","gcta","ttca","atgcatc"]
Output: "gctaagttcatgcatc"

*/

/*

Solution: graph[i][j] is the length of string to append when A[i] is followed by A[j]
          build the graph and the problem is to find the shortest path which visits each node exactly once
          use Travelling Salesman Problem DP solution and rebuild the path
O(2^n*n^2),O(2^n*n)          

*/

public String shortestSuperstring(String[] A) {
    int n = A.length;
    int[][] graph = new int[n][n];
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
            graph[i][j] = calc(A[i], A[j]);
            graph[j][i] = calc(A[j], A[i]);
        }
    }
    
    // use binary number i to indicate the status, dp[i][j] means the min length with i status and ended with jth string
    int[][] dp = new int[1 << n][n];
    
    int[][] path = new int[1 << n][n];
    int last = -1, min = Integer.MAX_VALUE;
    for (int i = 1; i < (1 << n); ++i) {
        Arrays.fill(dp[i], Integer.MAX_VALUE);
        for (int j = 0; j < n; ++j) {
            if ((i & (1 << j)) > 0) {  // means jth element is in the i status
                int prev = i - (1 << j);  // means the previous status without jth element
                if (prev == 0) dp[i][j] = A[j].length();
                else {
                
                    // for each element k, if it's the middle way element and can form a shorter path, update dp[i][j] 
                    for (int k = 0; k < n; ++k) {
                        if (dp[prev][k] != Integer.MAX_VALUE && dp[prev][k] + graph[k][j] < dp[i][j]) {
                            dp[i][j] = dp[prev][k] + graph[k][j];
                            path[i][j] = k;
                        }
                    }
                    
                }
            }
            
            // for the last status which visits all nodes, update the final minimum length
            if (i == (1 << n) - 1 && dp[i][j] < min) {
                min = dp[i][j];
                last = j;
            }
            
        }
    }
    StringBuilder ans = new StringBuilder();
    Deque<Integer> deque = new LinkedList<>();
    int cur = (1 << n) - 1;
    while (cur > 0) {
        deque.offerLast(last);
        int tmp = cur;
        cur -= (1 << last);
        last = path[tmp][last];
    }
    int i = deque.pollLast();
    ans.append(A[i]);
    while (!deque.isEmpty()) {
        int j = deque.pollLast();
        ans.append(A[j].substring(A[j].length() - graph[i][j]));
        i = j;
    }
    return ans.toString();
}

private int calc(String a, String b) {
    for (int i = 1; i < a.length(); ++i) {
        if (b.startsWith(a.substring(i))) return b.length() - a.length() + i;
    }
    return b.length();
}






