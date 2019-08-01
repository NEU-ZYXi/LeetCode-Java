
/*

Find the smallest prime palindrome greater than or equal to N.
Recall that a number is prime if it's only divisors are 1 and itself, and it is greater than 1. 
For example, 2,3,5,7,11 and 13 are primes.
Recall that a number is a palindrome if it reads the same from left to right as it does from right to left. 
For example, 12321 is a palindrome.

Example 1:
Input: 6
Output: 7

Example 2:
Input: 8
Output: 11

Example 3:
Input: 13
Output: 101

*/

/*

Solution: for each number, find the next palindrome and check whether it's prime number
          to get next palindrome, first build a valid palindrome using half of digits
          then check each digit, if any digit is less than original one, get the next palindrome by increasing the middle digit
O(n^2),O(n)          

*/

public int primePalindrome(int N) {
    while (true) {
        N = nextPalindrome(String.valueOf(N));
        if (isPrime(N)) {
            return N;
        }
        N++;
    }
}

private int nextPalindrome(String s) {
    char[] chars = s.toCharArray();
    int n = chars.length;
    char[] tmp = Arrays.copyOf(chars, n);
    for (int i = 0; i < n / 2; ++i) {
        tmp[n - i - 1] = tmp[i];
    }
    for (int i = 0; i < n; ++i) {
        if (chars[i] < tmp[i]) {
            return Integer.valueOf(new String(tmp));
        } else if (chars[i] > tmp[i]) {
            for (int j = (n - 1) / 2; j >= 0; --j) {
                if (++tmp[j] > '9') {
                    tmp[j] = '0';
                } else {
                    break;
                }
            }
            for (int j = 0; j < n / 2; ++j) {
                tmp[n - j - 1] = tmp[j];
            }
            return Integer.valueOf(new String(tmp));
        }
    }
    return Integer.valueOf(new String(tmp));
}

private boolean isPrime(int n) {
    if (n <= 1) {
        return false;
    }
    for (int i = 2; i * i <= n; ++i) {
        if (n % i == 0) {
            return false;
        }
    }
    return true;
}




