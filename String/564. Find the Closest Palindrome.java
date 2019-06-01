
/*

Given an integer n, find the closest integer (not including itself), which is a palindrome.
The 'closest' is defined as absolute difference minimized between two integers.

Example 1:
Input: "123"
Output: "121"

*/

/*

O(n^2),O(n)

*/

public String nearestPalindromic(String n) {
    long num = Long.valueOf(n);
    long high = findHighPalindrome(num + 1);
    long low = findLowPalindrome(num - 1);
    return Math.abs(num - high) >= Math.abs(num - low) ? String.valueOf(low) : String.valueOf(high);
}

private long findHighPalindrome(long num) {
    char[] s = String.valueOf(num).toCharArray();
    int n = s.length;
    char[] tmp = Arrays.copyOf(s, n);
    for (int i = 0; i < n / 2; ++i) {
        tmp[n - i - 1] = tmp[i];
    }
    for (int i = 0; i < n; ++i) {
        if (s[i] < tmp[i]) {
            return Long.valueOf(new String(tmp));
        } else if (s[i] > tmp[i]) {
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
            return Long.valueOf(new String(tmp));
        }
    }
    return Long.valueOf(new String(tmp));
}

private long findLowPalindrome(long num) {
    char[] s = String.valueOf(num).toCharArray();
    int n = s.length;
    char[] tmp = Arrays.copyOf(s, n);
    for (int i = 0; i < n / 2; ++i) {
        tmp[n - i - 1] = tmp[i];
    }
    for (int i = 0; i < n; ++i) {
        if (s[i] > tmp[i]) {
            return Long.valueOf(new String(tmp));
        } else if (s[i] < tmp[i]) {
            for (int j = (n - 1) / 2; j >= 0; --j) {
                if (--tmp[j] < '0') {
                    tmp[j] = '9';
                } else {
                    break;
                }
            }
            if (tmp[0] == '0') {
                char[] chars = new char[n - 1];
                Arrays.fill(chars, '9');
                return Long.valueOf(new String(chars));
            }
            for (int j = 0; j < n / 2; ++j) {
                tmp[n - j - 1] = tmp[j];
            }
            return Long.valueOf(new String(tmp));
        }
    }
    return Long.valueOf(new String(tmp));
}




