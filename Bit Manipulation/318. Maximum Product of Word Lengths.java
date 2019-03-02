
/*

Given a string array words, find the maximum of length(word[i]) * length(word[j]) where two words do not share common letters. 
You may assume that each word will contain only lower case letters. If no such two words exist, return 0.

Example 1:
Input: ["abcw","baz","foo","bar","xtfn","abcdef"]
Output: 16 
Explanation: The two words can be "abcw", "xtfn".

Example 2:
Input: ["a","ab","abc","d","cd","bcd","abcd"]
Output: 4 
Explanation: The two words can be "ab", "cd".

Example 3:
Input: ["a","aa","aaa","aaaa"]
Output: 0 
Explanation: No such pair of words.

*/

/*

O(n^2),O(n)

*/

public int maxProduct(String[] words) {
    int n = words.length, ans = 0;
    int[] masks = new int[n];
    for (int i = 0; i < n; ++i) {
        for (char c : words[i].toCharArray()) masks[i] |= 1 << (c - 'a');
    }
    for (int i = 0; i < n; ++i) {
        for (int j = i + 1; j < n; ++j) {
            if ((masks[i] & masks[j]) == 0) ans = Math.max(ans, words[i].length() * words[j].length());
        }
    }
    return ans;
}



