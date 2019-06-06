
/*

Given a string s and a list of strings dict, you need to add a closed pair of bold tag <b> and </b> 
to wrap the substrings in s that exist in dict. 
If two such substrings overlap, you need to wrap them together by only one pair of closed bold tag. 
Also, if two substrings wrapped by bold tags are consecutive, you need to combine them.

Example 1:
Input: 
s = "abcxyz123"
dict = ["abc","123"]
Output:
"<b>abc</b>xyz<b>123</b>"

Example 2:
Input: 
s = "aaabbcc"
dict = ["aaa","aab","bc"]
Output:
"<b>aaabbc</b>c"

*/

/*

O(nm),O(n) where n is length of s and m is length of dict

*/

public String addBoldTag(String s, String[] dict) {
    int n = s.length();
    boolean[] vis = new boolean[n];
    for (String str : dict) {
        int start = 0;
        while (start != -1) {
            start = s.indexOf(str, start);
            if (start == -1) {
                break;
            }
            int end = start + str.length();
            for (int i = start; i < end; ++i) {
                vis[i] = true;
            }
            start++;
        }
    }
    StringBuilder ans = new StringBuilder();
    for (int i = 0; i < n; ++i) {
        if (vis[i] && (i < 1 || !vis[i - 1])) {
            ans.append("<b>");
        }
        ans.append(s.charAt(i));
        if (vis[i] && (i == n - 1 || !vis[i + 1])) {
            ans.append("</b>");
        }
    }
    return ans.toString();
}



