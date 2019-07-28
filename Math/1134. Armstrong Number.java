
/*

The k-digit number N is an Armstrong number if and only if the k-th power of each digit sums to N.
Given a positive integer N, return true if and only if it is an Armstrong number.

Example 1:
Input: 153
Output: true
Explanation: 
153 is a 3-digit number, and 153 = 1^3 + 5^3 + 3^3.

Example 2:
Input: 123
Output: false
Explanation: 
123 is a 3-digit number, and 123 != 1^3 + 2^3 + 3^3 = 36.

*/

/*

O(logn),O(1)

*/

public boolean isArmstrong(int N) {
    int k = 0, num = N, ans = 0;
    while (num > 0) {
        num /= 10;
        k++;
    }
    num = N;
    while (num > 0) {
        int digit = num % 10;
        ans += Math.pow(digit, k);
        num /= 10;
    }
    return ans == N;
}



