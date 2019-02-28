
/*

Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once. 
You must make sure your result is the smallest in lexicographical order among all possible results.

Example 1:
Input: "bcabc"
Output: "abc"

Example 2:
Input: "cbacdcbc"
Output: "acdb"

*/

/*

Solution: 1. use buckets to count each character
          2. use a deque to store the current valid character, and a vis array to indicate whether the character is in deque
          3. when we have a new character which is lexicographically less than the last one in deque and we still have 
             available last one character, keep polling the last one in the deque until we find the position for current one
O(n),O(1)             

*/

public String removeDuplicateLetters(String s) {
    int[] buckets = new int[128];
    for (char c : s.toCharArray()) buckets[c]++;
    Deque<Integer> deque = new LinkedList<>();
    boolean[] vis = new boolean[128];
    for (int i = 0; i < s.length(); ++i) {
        int c = (int)s.charAt(i);
        buckets[c]--;
        if (vis[c]) continue;
        while (!deque.isEmpty() && deque.peekLast() > c && buckets[deque.peekLast()] > 0) vis[deque.pollLast()] = false;
        vis[c] = true;
        deque.offerLast(c);
    }
    StringBuilder ans = new StringBuilder();
    while (!deque.isEmpty()) ans.append((char)(int)deque.pollFirst());
    return ans.toString();
}




