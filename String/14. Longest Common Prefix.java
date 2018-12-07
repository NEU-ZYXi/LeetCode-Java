
/*

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:
Input: ["flower","flow","flight"]
Output: "fl"

Example 2:
Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

*/

/*

O(nk^2),O(1)

*/

public String longestCommonPrefix(String[] strs) {
    if (strs.length == 0) 
        return "";
    String ans = strs[0];
    for (int i = 1; i < strs.length; ++i) {
        while (strs[i].indexOf(ans) != 0)
            ans = ans.substring(0, ans.length() - 1);
    }
    return ans;
}
    
    
    
    
    
