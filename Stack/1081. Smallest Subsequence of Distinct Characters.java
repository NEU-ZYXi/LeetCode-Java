
/*

Return the lexicographically smallest subsequence of text that contains all the distinct characters of text exactly once.

Example 1:
Input: "cdadabcc"
Output: "adbc"

Example 2:
Input: "abcd"
Output: "abcd"

Example 3:
Input: "ecbacba"
Output: "eacb"

Example 4:
Input: "leetcode"
Output: "letcod"

*/

/*

Solution: same as 316. Remove Duplicate Letters 
          1. use buckets to count each character
          2. use a deque to store the current valid character, and a vis array to indicate whether the character is in deque
          3. when we have a new character which is lexicographically less than the last one in deque and we still have 
             available last one character, keep polling the last one in the deque until we find the position for current one
O(n),O(n) 

*/

public String smallestSubsequence(String text) {
    int[] buckets = new int[128];
    boolean[] vis = new boolean[128];
    for (char c : text.toCharArray()) {
        buckets[c]++;
    }
    Deque<Integer> deque = new ArrayDeque<>();
    for (int i = 0; i < text.length(); ++i) {
        int c = (int)text.charAt(i);
        buckets[c]--;
        if (vis[c]) {
            continue;
        }
        while (!deque.isEmpty() && deque.peekLast() > c && buckets[deque.peekLast()] > 0) {
            vis[deque.pollLast()] = false;
        }
        vis[c] = true;
        deque.offerLast(c);
    }
    StringBuilder ans = new StringBuilder();
    while (!deque.isEmpty()) {
        ans.append((char)(int)deque.pollFirst());
    }
    return ans.toString();
}



