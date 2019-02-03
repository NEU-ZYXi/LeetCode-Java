
/*

Given two strings s and t, determine if they are isomorphic.
Two strings are isomorphic if the characters in s can be replaced to get t.
All occurrences of a character must be replaced with another character while preserving the order of characters. 
No two characters may map to the same character but a character may map to itself.

Example 1:
Input: s = "egg", t = "add"
Output: true

Example 2:
Input: s = "foo", t = "bar"
Output: false

Example 3:
Input: s = "paper", t = "title"
Output: true

*/

/*

O(n),O(128)

*/

public boolean isIsomorphic(String s, String t) {
    if (s.length() != t.length()) return false;
    char[] ms = new char[128], mt = new char[128];
    for (int i = 0; i < s.length(); ++i) {
        char cs = s.charAt(i), ct = t.charAt(i);
        if (ms[cs] == 0 && mt[ct] == 0) {
            ms[cs] = ct;
            mt[ct] = cs;
        } else {
            if (ms[cs] != ct) return false;
        }
    }
    return true;
}




