
/*

Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
The order of output does not matter.

Example 1:
Input:
s: "cbaebabacd" p: "abc"
Output:
[0, 6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

Example 2:
Input:
s: "abab" p: "ab"
Output:
[0, 1, 2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

*/

/*

O(n),O(1)

*/

public List<Integer> findAnagrams(String s, String p) {
    List<Integer> ans = new ArrayList<>();
    int[] buckets = new int[128];
    int cnt = 0;
    for (char c : p.toCharArray()) buckets[c]++;
    for (int i = 0, j = 0; j < s.length(); ++j) {
        char r = s.charAt(j);
        if (buckets[r] > 0) cnt++;
        buckets[r]--;
        while (cnt == p.length()) {
            if (j - i + 1 == p.length()) ans.add(i);
            char l = s.charAt(i);
            buckets[l]++;
            if (buckets[l] > 0) cnt--;
            i++;
        }
    }
    return ans;
}




