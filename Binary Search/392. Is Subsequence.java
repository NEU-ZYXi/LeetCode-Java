
/*

Given a string s and a string t, check if s is subsequence of t.
You may assume that there is only lower case English letters in both s and t. 
t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).
A subsequence of a string is a new string which is formed from the original string 
by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. 
(ie, "ace" is a subsequence of "abcde" while "aec" is not).

Example 1:
s = "abc", t = "ahbgdc"
Return true.

Example 2:
s = "axc", t = "ahbgdc"
Return false.

Follow up:
If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, 
and you want to check one by one to see if T has its subsequence. 
In this scenario, how would you change your code?

*/

/*

Solution 1: find the first occurrence of each character, search next character only in remaining substring
O(n),O(1)

*/

public boolean isSubsequence(String s, String t) {
    for (int i = 0, j = 0; i < s.length(); ++i) {
        int idx = t.indexOf(s.charAt(i), j);
        if (idx == -1) return false;
        j = idx + 1;
    }
    return true;
}


/*

Solution 2: if we have a stream of S, preprocess T string and use binary search for each character in S
O(nlogm),O(m) where n is average length of S strings and m is the number of occurrence of each character

*/

public boolean isSubsequence(String s, String t) {
    List<Integer>[] map = new ArrayList[26];
    for (int i = 0; i < 26; ++i) map[i] = new ArrayList<>();
    for (int i = 0; i < t.length(); ++i) map[t.charAt(i) - 'a'].add(i);
    for (int i = 0, j = 0; i < s.length(); ++i) {
        char c = s.charAt(i);
        if (map[c - 'a'].size() == 0) return false;
        int idx = binarySearch(map[c - 'a'], j);
        if (idx == map[c - 'a'].size()) return false;
        j = map[c - 'a'].get(idx) + 1;
    }
    return true;
}

private int binarySearch(List<Integer> nums, int target) {
    int l = 0, r = nums.size() - 1;
    while (l <= r) {
        int mid = (l + r) / 2;
        if (nums.get(mid) == target) return mid;
        else if (nums.get(mid) < target) l = mid + 1;
        else r = mid - 1;
    }
    return l;
}




