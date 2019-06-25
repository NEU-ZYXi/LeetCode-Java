
/*

Given a list of words, each word consists of English lowercase letters.
Let's say word1 is a predecessor of word2 if and only if we can add exactly one letter anywhere in word1 to make it equal to word2. 
For example, "abc" is a predecessor of "abac".
A word chain is a sequence of words [word_1, word_2, ..., word_k] with k >= 1, 
where word_1 is a predecessor of word_2, word_2 is a predecessor of word_3, and so on.
Return the longest possible length of a word chain with words chosen from the given list of words.

Example 1:
Input: ["a","b","ba","bca","bda","bdca"]
Output: 4
Explanation: one of the longest word chain is "a","ba","bda","bdca".

*/

/*

Solution: sort the array by the length of string
          dp[i] means the max length for A[0...i]
          dp[i]=max(dp[j]+1) if A[j] is predecessor of A[i]
O(mn^2),O(n) where n is length of words and m is length of strings          

*/

public int longestStrChain(String[] words) {
    Arrays.sort(words, new Comparator<String>() {
        @Override
        public int compare(String a, String b) {
            return a.length() - b.length();
        }
    });
    int n = words.length, ans = 0;
    int[] dp = new int[n];
    Arrays.fill(dp, 1);
    for (int i = 0; i < n; ++i) {
        for (int j = i - 1; j >= 0 && words[i].length() - words[j].length() <= 1; --j) {
            if (isPredecessor(words[j], words[i])) {
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        ans = Math.max(ans, dp[i]);
    }
    return ans;
}

private boolean isPredecessor(String a, String b) {
    if (a.length() == b.length()) {
        return false;
    }
    int i = 0, j = 0, cnt = 0;
    while (i < a.length()) {
        if (a.charAt(i) == b.charAt(j)) {
            i++;
            j++;
        } else {
            cnt++;
            if (cnt > 1) {
                return false;
            }
            j++;
        }
    }
    return true;
}



