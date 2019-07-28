
/*

Given a set of keywords words and a string S, make all appearances of all keywords in S bold. 
Any letters between <b> and </b> tags become bold.
The returned string should use the least number of tags possible, and of course the tags should form a valid combination.
For example, given that words = ["ab", "bc"] and S = "aabcd", we should return "a<b>abc</b>d". 
Note that returning "a<b>a<b>b</b>c</b>d" would use more tags, so it is incorrect.

*/

/*

O(nm),O(n)

*/

public String boldWords(String[] words, String S) {
    int n = S.length();
    boolean[] vis = new boolean[n];
    for (String str : words) {
        int start = 0;
        while (start != -1) {
            start = S.indexOf(str, start);
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
        ans.append(S.charAt(i));
        if (vis[i] && (i == n - 1 || !vis[i + 1])) {
            ans.append("</b>");
        }
    }
    return ans.toString();
}



