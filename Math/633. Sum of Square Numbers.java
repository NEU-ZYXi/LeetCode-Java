
/*

Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a2 + b2 = c.

Example 1:
Input: 5
Output: True
Explanation: 1 * 1 + 2 * 2 = 5
 
Example 2:
Input: 3
Output: False

*/

/*

O(sqrt(n)),O(1)

*/

public boolean judgeSquareSum(int c) {
    int l = 0, r = (int)Math.sqrt(c);
    while (l <= r) {
        int n = l * l + r * r;
        if (n == c) {
            return true;
        } else if (n > c) {
            r--;
        } else {
            l++;
        }
    }
    return false;
}



