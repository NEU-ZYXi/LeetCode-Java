
/*

Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.

Example:
Input: 13
Output: 6 
Explanation: Digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.

*/

/*

Solution: 
O(k),O(1), where k is the number of digits

*/

public int countDigitOne(int n) {
    int x = n, y = 1, ans = 0;
    while (x > 0) {
        int digit = x % 10;
        x /= 10;
        ans += x * y;
        if (digit == 1) ans += n % y + 1;
        else if (digit > 1) ans += y;
        y *= 10;
    }
    return ans;
}



