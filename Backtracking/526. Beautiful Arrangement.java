
/*

Suppose you have N integers from 1 to N. We define a beautiful arrangement as an array 
that is constructed by these N numbers successfully if one of the following is true for the ith position (1 <= i <= N) 
in this array:
The number at the ith position is divisible by i.
i is divisible by the number at the ith position.
Now given N, how many beautiful arrangements can you construct?

Example 1:
Input: 2
Output: 2
Explanation: 
The first beautiful arrangement is [1, 2]:
Number at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).
Number at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).
The second beautiful arrangement is [2, 1]:
Number at the 1st position (i=1) is 2, and 2 is divisible by i (i=1).
Number at the 2nd position (i=2) is 1, and i (i=2) is divisible by 1.

*/

/*

Solution: backtrack to try each position with i%nums[i]=0 or nums[i]%i=0
O(2^n),O(n)

*/

public int countArrangement(int N) {
    boolean[] vis = new boolean[N + 1];
    return dfs(vis, N, N);
}

private int dfs(boolean[] vis, int N, int cur) {
    if (cur <= 0) {
        return 1;
    }
    int ans = 0;
    for (int i = N; i >= 1; --i) {
        if (!vis[i] && (i % cur == 0 || cur % i == 0)) {
            vis[i] = true;
            ans += dfs(vis, N, cur - 1);
            vis[i] = false;
        }
    }
    return ans;
}




