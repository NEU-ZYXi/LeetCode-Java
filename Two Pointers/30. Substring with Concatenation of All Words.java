
/*

You are given a string, s, and a list of words, words, that are all of the same length. 
Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and 
without any intervening characters.

Example 1:
Input:
  s = "barfoothefoobarman",
  words = ["foo","bar"]
Output: [0,9]
Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar" respectively.
The output order does not matter, returning [9,0] is fine too.

Example 2:
Input:
  s = "wordgoodstudentgoodword",
  words = ["word","student"]
Output: []

*/

/*

Solution 1.
O(len*(n/len))=O(n),O(m)

*/

public List<Integer> findSubstring(String s, String[] words) {
    List<Integer> ans = new ArrayList<>();
    if (words.length == 0)
        return ans;
    Map<String, Integer> map = new HashMap<>();
    for (String word : words) map.put(word, map.getOrDefault(word, 0) + 1);
    Map<String, Integer> tmp = new HashMap<>();
    int n = s.length(), m = words.length, len = words[0].length();
    for (int i = 0; i < len; ++i) {
        int l = i, r = i, cnt = 0;
        while (r <= n - len) {
            String right = s.substring(r, r + len);
            if (!map.containsKey(right)) {
                tmp.clear();
                cnt = 0;
                l = r + len;
            } else {
                tmp.put(right, tmp.getOrDefault(right, 0) + 1);
                cnt++;
                while (tmp.get(right) > map.get(right)) {
                    String left = s.substring(l, l + len);
                    tmp.put(left, tmp.get(left) - 1);
                    cnt--;
                    l += len;
                }
                if (cnt == m) ans.add(l);
            }
            r += len;
        }
        tmp.clear();
    }
    return ans;
}


/*

Solution 2.
O((n-m)*m)=(nm),O(m)

*/

public List<Integer> findSubstring(String s, String[] words) {
    List<Integer> ans = new ArrayList<>();
    if (words.length == 0)
        return ans;
    Map<String, Integer> map = new HashMap<>();
    for (String word : words) map.put(word, map.getOrDefault(word, 0) + 1);
    Map<String, Integer> tmp = new HashMap<>();
    int n = s.length(), m = words.length, len = words[0].length();
    for (int i = 0; i < n - m * len + 1; ++i) {
        int cnt = 0;
        while (cnt < m) {
            String word = s.substring(i + cnt * len, i + (cnt + 1) * len);
            if (!map.containsKey(word)) break;
            else {
                tmp.put(word, tmp.getOrDefault(word, 0) + 1);
                if (tmp.get(word) > map.get(word)) break;
                cnt++;
            }
        }
        if (cnt == m) ans.add(i);
        tmp.clear();
    }
    return ans;
}





