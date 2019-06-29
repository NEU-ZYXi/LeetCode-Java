
/*

From any string, we can form a subsequence of that string by deleting some number of characters (possibly no deletions).
Given two strings source and target, return the minimum number of subsequences of source such that their concatenation equals target.
If the task is impossible, return -1.

Example 1:
Input: source = "abc", target = "abcbc"
Output: 2
Explanation: The target "abcbc" can be formed by "abc" and "bc", which are subsequences of source "abc".

Example 2:
Input: source = "abc", target = "acdbc"
Output: -1
Explanation: The target string cannot be constructed from the subsequences of source string due to the character "d" in target string.

Example 3:
Input: source = "xyz", target = "xzyxz"
Output: 3
Explanation: The target string can be constructed as follows "xz" + "y" + "xz".

*/

/*

O(n),O(1)

*/

public int shortestWay(String source, String target) {
    int ans = 0, i = 0;
    while (i < target.length()) {
        int tmp = i;
        for (int j = 0; j < source.length(); ++j) {
            if (i < target.length() && source.charAt(j) == target.charAt(i)) {
                i++;
            }
        }
        if (i == tmp) {
            return -1;
        }
        ans++;
    }
    return ans;
}



