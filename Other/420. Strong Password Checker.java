
/*

A password is considered strong if below conditions are all met:
It has at least 6 characters and at most 20 characters.
It must contain at least one lowercase letter, at least one uppercase letter, and at least one digit.
It must NOT contain three repeating characters in a row ("...aaa..." is weak, but "...aa...a..." is strong, 
assuming other conditions are met).
Write a function strongPasswordChecker(s), that takes a string s as input, 
and return the MINIMUM change required to make s a strong password. If s is already strong, return 0.
Insertion, deletion or replace of any one character are all considered as one change.

*/

/*

Solution: replace > insert > delete, greedily perform the three operations
O(n),O(n)

*/

public int strongPasswordChecker(String s) {
    int n = s.length(), ans = 0, lower = 1, upper = 1, digit = 1;
    char[] chars = s.toCharArray();
    int[] duplicate = new int[n];
    for (int i = 0; i < n; ) {
        if (Character.isDigit(chars[i])) digit = 0;
        if (Character.isLowerCase(chars[i])) lower = 0;
        if (Character.isUpperCase(chars[i])) upper = 0;
        int j = i;
        while (i < n && chars[i] == chars[j]) i++;
        duplicate[j] = i - j;
    }
    int missing = lower + upper + digit;
    if (n < 6) return Math.max(0, 6 - (n + missing)) + missing;
    else {
        int overLen = Math.max(0, n - 20), extra = 0;
        ans += overLen;
        for (int i = 1; i < 3; ++i) {
            for (int j = 0; j < n && overLen > 0; ++j) {
                if (duplicate[j] < 3 || duplicate[j] % 3 != (i - 1)) continue;
                duplicate[j] -= Math.min(overLen, i);
                overLen -= i;
            }
        }
        for (int i = 0; i < n; ++i) {
            if (duplicate[i] >= 3 && overLen > 0) {
                int op = duplicate[i] - 2;
                duplicate[i] -= overLen;
                overLen -= op;
            }
            if (duplicate[i] >= 3) extra += duplicate[i] / 3;
        }
        ans += Math.max(missing, extra);
    }
    return ans;
}




