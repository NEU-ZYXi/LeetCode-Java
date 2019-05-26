
/*

Given a list of strings, you need to find the longest uncommon subsequence among them. 
The longest uncommon subsequence is defined as the longest subsequence of one of these strings 
and this subsequence should not be any subsequence of the other strings.
A subsequence is a sequence that can be derived from one sequence by deleting some characters 
without changing the order of the remaining elements. 
Trivially, any string is a subsequence of itself and an empty string is a subsequence of any string.
The input will be a list of strings, and the output needs to be the length of the longest uncommon subsequence. 
If the longest uncommon subsequence doesn't exist, return -1.

Example 1:
Input: "aba", "cdc", "eae"
Output: 3

*/

/*

O(mn^2),O(1) where n is the length of strs and m is average length of strs

*/

public int findLUSlength(String[] strs) {
    int ans = -1, n = strs.length;
    for (int i = 0; i < n; ++i) {
        boolean isSub = false;
        for (int j = 0; j < n; ++j) {
            if (i != j) {
                if (isSub(strs[i], strs[j])) {
                    isSub = true;
                    break;
                }
            }
        }
        if (!isSub) {
            ans = Math.max(ans, strs[i].length());
        }
    }
    return ans;
}

private boolean isSub(String a, String b) {
    if (a.length() > b.length()) {
        return false;
    }
    int i = 0, j = 0;
    while (i < a.length() && j < b.length()) {
        if (a.charAt(i) == b.charAt(j)) {
            i++;
            j++;
        } else {
            j++;
        }
    }
    return i == a.length();
}





