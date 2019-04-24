
/*

Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:
s = "leetcode"
return 0.

s = "loveleetcode",
return 2.

*/

/*

O(n),O(1)

*/

public int firstUniqChar(String s) {
    int[] buckets = new int[26];
    for (char c : s.toCharArray()) buckets[c - 'a']++;
    for (int i = 0; i < s.length(); ++i) {
        if (buckets[s.charAt(i) - 'a'] == 1) return i;
    }
    return -1;
}




