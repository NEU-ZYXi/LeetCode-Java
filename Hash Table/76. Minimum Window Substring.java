
/*

Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:
Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"

*/

/*

O(n),O(n)

*/

public String minWindow(String s, String t) {
    String ans = "";
    Map<Character, Integer> map = new HashMap<>();
    for (char c : t.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
    int cnt = 0;
    for (int i = 0, j = 0; j < s.length(); ++j) {
        char right = s.charAt(j);
        if (map.containsKey(right)) {
            map.put(right, map.get(right) - 1);
            if (map.get(right) >= 0) cnt++;
        }
        while (cnt == t.length()) {
            if (ans.length() == 0 || ans.length() > j - i + 1) ans = s.substring(i, j + 1);
            char left = s.charAt(i);
            if (map.containsKey(left)) {
                map.put(left, map.get(left) + 1);
                if (map.get(left) > 0) cnt--;
            }
            i++;
        }
    }
    return ans;
}




