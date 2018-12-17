
/*

Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word.
If the last word does not exist, return 0.
Note: A word is defined as a character sequence consists of non-space characters only.

Example:
Input: "Hello World"
Output: 5

*/

/*

O(n),O(1)

*/

public int lengthOfLastWord(String s) {
    s = s.trim();
    int ans = 0;
    for (int i = s.length() - 1; i >= 0; --i) {
        if (s.charAt(i) == ' ') break;
        else ans++;
    }
    return ans;
}



