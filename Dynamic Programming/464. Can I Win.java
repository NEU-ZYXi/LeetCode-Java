
/*

In the "100 game," two players take turns adding, to a running total, any integer from 1..10. 
The player who first causes the running total to reach or exceed 100 wins.
What if we change the game so that players cannot re-use integers?

Given an integer maxChoosableInteger and another integer desiredTotal, 
determine if the first player to move can force a win, assuming both players play optimally.
You can always assume that maxChoosableInteger will not be larger than 20 and desiredTotal will not be larger than 300.

Example
Input:
maxChoosableInteger = 10
desiredTotal = 11
Output:
false
Explanation:
No matter which integer the first player choose, the first player will lose.
The first player can choose an integer from 1 up to 10.
If the first player choose 1, the second player can only choose integers from 2 up to 10.
The second player will win by choosing 10 and get a total = 11, which is >= desiredTotal.
Same with other integers chosen by the first player, the second player will always win.

*/

/*

O(2^n),O(2^n)

*/

public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
    if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) return false;
    int[] vis = new int[maxChoosableInteger + 1];
    Map<Integer, Boolean> memo = new HashMap<>();
    return dfs(memo, vis, desiredTotal);
}

private boolean dfs(Map<Integer, Boolean> memo, int[] vis, int total) {
    Integer state = getHash(vis);
    if (memo.containsKey(state)) return memo.get(state);
    for (int i = 1; i < vis.length; ++i) {
        if (vis[i] == 0) {
            vis[i] = 1;
            if (total <= i || !dfs(memo, vis, total - i)) {
                memo.put(state, true);
                vis[i] = 0;
                return true;
            }
            vis[i] = 0;
        }
    }
    memo.put(state, false);
    return false;
}

private int getHash(int[] vis) {
    int state = 0;
    for (int val : vis) {
        state <<= 1;
        state |= val == 1 ? 1 : 0;
    }
    return state;
}





