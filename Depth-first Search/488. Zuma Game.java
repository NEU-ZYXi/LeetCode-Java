
/*

Think about Zuma Game. You have a row of balls on the table, colored red(R), yellow(Y), blue(B), green(G), and white(W). 
You also have several balls in your hand.
Each time, you may choose a ball in your hand, and insert it into the row (including the leftmost place and rightmost place). 
Then, if there is a group of 3 or more balls in the same color touching, remove these balls. 
Keep doing this until no more balls can be removed.
Find the minimal balls you have to insert to remove all the balls on the table. If you cannot remove all the balls, output -1.

Examples:
Input: "WRRBBW", "RB"
Output: -1
Explanation: WRRBBW -> WRR[R]BBW -> WBBW -> WBB[B]W -> WW

Input: "WWRRBBWW", "WRBRW"
Output: 2
Explanation: WWRRBBWW -> WWRR[R]BBWW -> WWBBWW -> WWBB[B]WW -> WWWW -> empty

Input:"G", "GGGGG"
Output: 2
Explanation: G -> G[G] -> GG[G] -> empty 

Input: "RBYYBBRRB", "YRBGB"
Output: 3
Explanation: RBYYBBRRB -> RBYY[Y]BBRRB -> RBBBRRB -> RRRB -> B -> B[B] -> BB[B] -> empty 

*/

/*

Solution: for each consecutive part, count it or not, backtrack for all possible parts
O(n^n),O(n)

*/

public int findMinStep(String board, String hand) {
    int[] buckets = new int[128];
    for (char c : hand.toCharArray()) {
        buckets[c]++;
    }
    return dfs(board, buckets);
}

private int dfs(String s, int[] buckets) {
    int n = s.length();
    if (n == 0) {
        return 0;
    }
    int ans = Integer.MAX_VALUE;
    for (int i = 0; i < n; ) {
        int j = i;
        char c = s.charAt(j);
        while (i < n && s.charAt(i) == c) {
            i++;
        }
        int cnt = 3 - i + j;
        if (buckets[c] >= cnt) {
            int used = cnt <= 0 ? 0 : cnt;
            buckets[c] -= used;
            int tmp = dfs(s.substring(0, j) + s.substring(i), buckets);
            if (tmp != -1) {
                ans = Math.min(ans, used + tmp);
            }
            buckets[c] += used;
        }
    }
    return ans == Integer.MAX_VALUE ? -1 : ans;
}





