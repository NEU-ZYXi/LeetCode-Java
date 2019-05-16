
/*

Find the largest palindrome made from the product of two n-digit numbers.
Since the result could be very large, you should return the largest palindrome mod 1337.

Example:
Input: 2
Output: 987
Explanation: 99 x 91 = 9009, 9009 % 1337 = 987

*/

/*

O(10^n),O(1)

*/

public int largestPalindrome(int n) {
    long max = (long)Math.pow(10, n) - 1, min = max / 10 + 1;
    for (long left = max; left >= min; --left) {
        long target = buildPalindrome(left + "");
        for (long i = max; i * i >= target; --i) {
            if (target % i == 0) {
                return (int)(target % 1337);
            }
        }
    }
    return 9;
}

private long buildPalindrome(String left) {
    String right = "";
    for (char c : left.toCharArray()) {
        right = c + right;
    }
    return Long.valueOf(left + right);
}




