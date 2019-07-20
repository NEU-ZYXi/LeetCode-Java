
/*

Given a string S, remove the vowels 'a', 'e', 'i', 'o', and 'u' from it, and return the new string.

Example 1:
Input: "leetcodeisacommunityforcoders"
Output: "ltcdscmmntyfrcdrs"

Example 2:
Input: "aeiou"
Output: ""

*/

/*

O(n),O(1)

*/

public String removeVowels(String S) {
    return S.replaceAll("['a', 'e', 'i', 'o', 'u']", "");
}


