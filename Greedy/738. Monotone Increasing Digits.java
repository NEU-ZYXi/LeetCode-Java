
/*

Given a non-negative integer N, find the largest number that is less than or equal to N with monotone increasing digits.
(Recall that an integer has monotone increasing digits if and only if each pair of adjacent digits x and y satisfy x <= y.)

Example 1:
Input: N = 10
Output: 9

Example 2:
Input: N = 1234
Output: 1234

Example 3:
Input: N = 332
Output: 299

*/

/*

Solution: greedily find the leftmost mismatch index of character and decrease it by 1, then set all following as '9'
O(n),O(n)

*/

public int monotoneIncreasingDigits(int N) {
    if (N < 10) {
        return N - 1;
    }
    char[] digits = String.valueOf(N).toCharArray();
    int n = digits.length, idx = -1;
    boolean increasing = false;
    for (int i = n - 1; i > 0; --i) {
        if (digits[i] > digits[i - 1]) {
            increasing = true;
        } else if (digits[i] < digits[i - 1]) {
            increasing = false;
            idx = i - 1;
        } else if (!increasing && digits[i] == digits[i - 1]) {
            idx = i - 1;
        }
    }
    if (idx != -1) {
        digits[idx]--;
        for (int i = idx + 1; i < n; ++i) {
            digits[i] = '9';
        }
    }
    return Integer.valueOf(new String(digits));
}




