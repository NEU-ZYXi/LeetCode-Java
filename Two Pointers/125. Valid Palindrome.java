
/*

Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:
Input: "A man, a plan, a canal: Panama"
Output: true

Example 2:
Input: "race a car"
Output: false

*/

/*

O(n),O(1)

*/

public boolean isPalindrome(String s) {
    int l = 0, r = s.length() - 1;
    while (l < r) {
        if (!Character.isLetterOrDigit(s.charAt(l))) l++;
        else if (!Character.isLetterOrDigit(s.charAt(r))) r--;
        else if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) return false;
        else {
            l++;
            r--;
        }
    }
    return true;
}



