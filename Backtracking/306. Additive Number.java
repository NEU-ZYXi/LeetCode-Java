
/*

Additive number is a string whose digits can form additive sequence.
A valid additive sequence should contain at least three numbers. 
Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.
Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.
Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.

Example 1:
Input: "112358"
Output: true 
Explanation: The digits can form an additive sequence: 1, 1, 2, 3, 5, 8. 
             1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
             
Example 2:
Input: "199100199"
Output: true 
Explanation: The additive sequence is: 1, 99, 100, 199. 
             1 + 99 = 100, 99 + 100 = 199

*/

/*

O(n^n),O(n)

*/

public boolean isAdditiveNumber(String num) {
    if (num.length() < 3) return false;
    return dfs(num, 0, -1, -1, -1);
}

private boolean dfs(String num, int idx, long first, long second, long third) {
    if (idx == num.length()) {
        if (first == -1 || second == -1 || third == -1) return false;
        return first + second == third;
    }
    if (num.charAt(idx) == '0') return dfs(num, idx + 1, second, third, 0);
    boolean ans = false;
    for (int i = idx; i < num.length() && i - idx < 19; ++i) {
        long cur = Long.valueOf(num.substring(idx, i + 1));
        if (second == -1 || third == -1 || second + third == cur) ans |= dfs(num, i + 1, second, third, cur);
        else if (second + third < cur) break;
    }
    return ans;
}




