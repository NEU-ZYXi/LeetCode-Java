
/*

Given a string and a string dictionary, find the longest string in the dictionary 
that can be formed by deleting some characters of the given string. 
If there are more than one possible results, return the longest word with the smallest lexicographical order. 
If there is no possible result, return the empty string.

Example 1:
Input:
s = "abpcplea", d = ["ale","apple","monkey","plea"]
Output: 
"apple"

Example 2:
Input:
s = "abpcplea", d = ["a","b","c"]
Output: 
"a"

*/

/*

O(nm),O(1)

*/

public String findLongestWord(String s, List<String> d) {
    String ans = "";
    for (String str : d) {
        if (isSub(str, s)) {
            if (str.length() > ans.length() || (str.length() == ans.length() && str.compareTo(ans) < 0)) {
                ans = str;
            }
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




