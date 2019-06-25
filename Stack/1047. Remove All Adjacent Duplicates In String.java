
/*

Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent and equal letters, and removing them.
We repeatedly make duplicate removals on S until we no longer can.
Return the final string after all such duplicate removals have been made.  It is guaranteed the answer is unique.

Example 1:
Input: "abbaca"
Output: "ca"
Explanation: 
For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  
The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".

*/

/*

O(n),O(n)

*/

public String removeDuplicates(String S) {
    Deque<Character> deque = new ArrayDeque<>();
    StringBuilder ans = new StringBuilder();
    for (char c : S.toCharArray()) {
        if (!deque.isEmpty() && deque.peekLast() == c) {
            deque.pollLast();
        } else {
            deque.offerLast(c);
        }
    }
    while (!deque.isEmpty()) {
        ans.append(deque.pollFirst());
    }
    return ans.toString();
}



