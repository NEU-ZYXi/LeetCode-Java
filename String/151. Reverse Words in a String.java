
/*

Given an input string, reverse the string word by word.

Example:  
Input: "the sky is blue",
Output: "blue is sky the".

Note:
A word is defined as a sequence of non-space characters.
Input string may contain leading or trailing spaces. 
However, your reversed string should not contain leading or trailing spaces.
You need to reduce multiple spaces between two words to a single space in the reversed string.

*/

/*

O(n),O(n)

*/

public String reverseWords(String s) {
    s = s.trim();
    String[] strs = s.split("\\s+");
    StringBuilder sb = new StringBuilder();
    for (int i = strs.length - 1; i >= 0; --i) sb.append(strs[i]).append(" ");
    sb.setLength(sb.length() - 1);
    return sb.toString();
}




