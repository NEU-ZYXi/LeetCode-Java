
/*

Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false

*/

/*

O(n),O(n)

*/

public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) return false;
    int[] buckets = new int[128];
    for (int i = 0; i < s.length(); ++i) buckets[s.charAt(i)]++;
    for (int i = 0; i < t.length(); ++i) {
        if (buckets[t.charAt(i)] == 0) return false;
        buckets[t.charAt(i)]--;
    }
    return true;
}




