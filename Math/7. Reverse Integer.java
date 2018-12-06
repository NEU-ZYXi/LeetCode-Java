
/*

Given a 32-bit signed integer, reverse digits of an integer.

Example 1:
Input: 123
Output: 321

Example 2:
Input: -123
Output: -321

Example 3:
Input: 120
Output: 21

Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer: [−2^31, 2^31 − 1]. 
For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

*/

/*

O(1),O(1)

*/

public int reverse(int x) {
    int ans = 0;
    while (x != 0) {
        int mod = x % 10, tmp = ans * 10 + mod;
        if ((tmp - mod) / 10 != ans)
            return 0;
        ans = tmp;
        x /= 10;
    }
    return ans;
}




