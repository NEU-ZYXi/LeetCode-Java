
/*

Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
word1 and word2 may be the same and they represent two individual words in the list.

Example:
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Input: word1 = “makes”, word2 = “coding”
Output: 1

Input: word1 = "makes", word2 = "makes"
Output: 3

*/

/*

O(n),O(1)

*/

public int shortestWordDistance(String[] words, String word1, String word2) {
    int idx1 = -1, idx2 = -1, ans = Integer.MAX_VALUE;
    for (int i = 0; i < words.length; ++i) {
        if (words[i].equals(word1)) {
            if (word1.equals(word2)) {
                idx2 = idx1;
                idx1 = i;
            } else idx1 = i;
        } else if (words[i].equals(word2)) idx2 = i;
        if (idx1 != -1 && idx2 != -1) ans = Math.min(ans, Math.abs(idx1 - idx2));
    }
    return ans;
}




