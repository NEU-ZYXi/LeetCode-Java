
/*

Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

Example 1:
Input: "aba"
Output: True

Example 2:
Input: "abca"
Output: True
Explanation: You could delete the character 'c'.

*/

/*

Solution 1: O(n),O(1)

*/

public boolean validPalindrome(String s) {
    int l = 0, r = s.length() - 1;
    while (l < r) {
        if (s.charAt(l) != s.charAt(r)) {
            break;
        }
        l++;
        r--;
    }
    if (l >= r) {
        return true;
    }
    if (isPalindrome(s.substring(l, r)) || isPalindrome(s.substring(l + 1, r + 1))) {
        return true;
    }
    return false;
}

private boolean isPalindrome(String s) {
    int l = 0, r = s.length() - 1;
    while (l < r) {
        if (s.charAt(l) != s.charAt(r)) {
            return false;
        }
        l++;
        r--;
    }
    return true;
}


/*

Solution 2: general pattern to remove at most k characters
O(n),O(1)

*/

public boolean validPalindrome(String s) {
    return validPalindrome(s, 0, s.length() - 1, 1);
}

private boolean validPalindrome(String s, int l, int r, int k) {
    if (l >= r) {
        return true;
    }
    if (s.charAt(l) == s.charAt(r)) {
        return validPalindrome(s, l + 1, r - 1, k);
    } else {
        return k > 0 && (validPalindrome(s, l + 1, r, k - 1) || validPalindrome(s, l, r - 1, k - 1));
    }
}




