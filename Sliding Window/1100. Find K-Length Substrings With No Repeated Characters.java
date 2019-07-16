
/*

Given a string S, return the number of substrings of length K with no repeated characters.

Example 1:
Input: S = "havefunonleetcode", K = 5
Output: 6
Explanation: 
There are 6 substrings they are : 'havef','avefu','vefun','efuno','etcod','tcode'.

Example 2:
Input: S = "home", K = 5
Output: 0
Explanation: 
Notice K can be larger than the length of S. In this case is not possible to find any substring.

*/

/*

O(n),O(1)

*/

public int numKLenSubstrNoRepeats(String S, int K) {
    int[] buckets = new int[26];
    int ans = 0;
    for (int i = 0, j = 0; j < S.length(); ++j) {
        buckets[S.charAt(j) - 'a']++;
        while (buckets[S.charAt(j) - 'a'] > 1) {
            buckets[S.charAt(i) - 'a']--;
            i++;
        }
        if (j - i + 1 >= K) {
            ans++;
        }
    }
    return ans;
}



