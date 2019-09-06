
/*

We are given N different types of stickers. Each sticker has a lowercase English word on it.
You would like to spell out the given target string by cutting individual letters from your collection of stickers and rearranging them.
You can use each sticker more than once if you want, and you have infinite quantities of each sticker.
What is the minimum number of stickers that you need to spell out the target? If the task is impossible, return -1.

Example 1:
Input:
["with", "example", "science"], "thehat"
Output:
3
Explanation:
We can use 2 "with" stickers, and 1 "example" sticker.
After cutting and rearrange the letters of those stickers, we can form the target "thehat".
Also, this is the minimum number of stickers necessary to form the target string.

Example 2:
Input:
["notice", "possible"], "basicbasic"
Output:
-1
Explanation:
We can't form the target "basicbasic" from cutting letters from the given stickers.

*/

/*

Solution: DFS and memo to backtrack all combinations of stickers, build remaining string as next step
O(n^m),O(m) where n is length of stickers and m is average length of stickers

*/

public int minStickers(String[] stickers, String target) {
    int n = stickers.length;
    int[][] map = new int[n][128];
    Map<String, Integer> memo = new HashMap<>();
    for (int i = 0; i < n; ++i) {
        for (char c : stickers[i].toCharArray()) {
            map[i][c]++;
        }
    }
    memo.put("", 0);
    return dfs(memo, map, target);
}

private int dfs(Map<String, Integer> memo, int[][] map, String target) {
    if (memo.containsKey(target)) {
        return memo.get(target);
    }
    int n = map.length, ans = Integer.MAX_VALUE;
    int[] chars = new int[128];
    for (char c : target.toCharArray()) {
        chars[c]++;
    }
    for (int i = 0; i < n; ++i) {
        if (map[i][target.charAt(0)] == 0) {
            continue;
        }
        StringBuilder sb = new StringBuilder();
        for (char c = 'a'; c <= 'z'; ++c) {
            if (chars[c] > 0) {
                for (int j = 0; j < Math.max(0, chars[c] - map[i][c]); ++j) {
                    sb.append(c);
                }
            }
        }
        int next = dfs(memo, map, sb.toString());
        if (next != -1) {
            ans = Math.min(ans, 1 + next);
        }
    }
    memo.put(target, ans == Integer.MAX_VALUE ? -1 : ans);
    return memo.get(target);
}




