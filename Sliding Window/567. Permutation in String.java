
/*

Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. 
In other words, one of the first string's permutations is the substring of the second string.

Example 1:
Input: s1 = "ab" s2 = "eidbaooo"
Output: True
Explanation: s2 contains one permutation of s1 ("ba").

Example 2:
Input:s1= "ab" s2 = "eidboaoo"
Output: False

*/

/*

O(n),O(1)

*/

public boolean checkInclusion(String s1, String s2) {
    int[] buckets = new int[128];
    for (char c : s1.toCharArray()) {
        buckets[c]++;
    }
    for (int i = 0, j = 0; j < s2.length(); ++j) {
        buckets[s2.charAt(j)]--;
        while (buckets[s2.charAt(j)] < 0) {
            buckets[s2.charAt(i)]++;
            i++;
        }
        if (j - i + 1 == s1.length()) {
            return true;
        }
    }
    return false;
}




