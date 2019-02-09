
/*

Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

Example:
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Input: word1 = “coding”, word2 = “practice”
Output: 3

Input: word1 = "makes", word2 = "coding"
Output: 1

*/

/*

O(n),O(1)

*/

public int shortestDistance(String[] words, String word1, String word2) {
    int idx1 = -1, idx2 = -1, ans = Integer.MAX_VALUE;
    for (int i = 0; i < words.length; ++i) {
        if (words[i].equals(word1)) idx1 = i;
        else if (words[i].equals(word2)) idx2 = i;
        if (idx1 != -1 && idx2 != -1) ans = Math.min(ans, Math.abs(idx1 - idx2));
    }
    return ans;
}




