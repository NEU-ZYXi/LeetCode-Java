
/*

Given a string, determine if a permutation of the string could form a palindrome.

Example 1:
Input: "code"
Output: false

Example 2:
Input: "aab"
Output: true

Example 3:
Input: "carerac"
Output: true

*/

/*

O(n),O(1)

*/

public boolean canPermutePalindrome(String s) {
    int[] buckets = new int[128];
    int cnt = 0;
    for (int i = 0; i < s.length(); ++i) buckets[s.charAt(i)]++;
    for (int i = 0; i < buckets.length; ++i) {
        if (buckets[i] % 2 == 1) cnt++;
        if (cnt > 1) return false;
    }
    return true;
}



