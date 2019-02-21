
/*

Given a pattern and a string str, find if str follows the same pattern.
Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Example 1:
Input: pattern = "abba", str = "dog cat cat dog"
Output: true

Example 2:
Input:pattern = "abba", str = "dog cat cat fish"
Output: false

Example 3:
Input: pattern = "aaaa", str = "dog cat cat dog"
Output: false

Example 4:
Input: pattern = "abba", str = "dog dog dog dog"
Output: false

*/

/*

O(n),O(n)

*/

public boolean wordPattern(String pattern, String str) {
    String[] words = str.split("\\s+");
    if (pattern.length() != words.length) return false;
    Map<Character, String> map = new HashMap<>();
    Set<String> vis = new HashSet<>();
    for (int i = 0; i < words.length; ++i) {
        char c = pattern.charAt(i);
        if (!map.containsKey(c)) {
            if (!vis.add(words[i])) return false;
            map.put(c, words[i]);
        } else if (!map.get(c).equals(words[i])) return false;
    }
    return true;
}




