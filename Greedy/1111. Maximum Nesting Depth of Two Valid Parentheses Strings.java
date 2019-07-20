
/*

A string is a valid parentheses string (denoted VPS) if and only if it consists of "(" and ")" characters only, and:
It is the empty string, or
It can be written as AB (A concatenated with B), where A and B are VPS's, or
It can be written as (A), where A is a VPS.
We can similarly define the nesting depth depth(S) of any VPS S as follows:
depth("") = 0
depth(A + B) = max(depth(A), depth(B)), where A and B are VPS's
depth("(" + A + ")") = 1 + depth(A), where A is a VPS.
For example,  "", "()()", and "()(()())" are VPS's (with nesting depths 0, 1, and 2), and ")(" and "(()" are not VPS's.
Given a VPS seq, split it into two disjoint subsequences A and B, such that A and B are VPS's (and A.length + B.length = seq.length).
Now choose any such A and B such that max(depth(A), depth(B)) is the minimum possible value.
Return an answer array (of length seq.length) that encodes such a choice of A and B: 
answer[i] = 0 if seq[i] is part of A, else answer[i] = 1.  
Note that even though multiple answers may exist, you may return any of them.

Example 1:
Input: seq = "(()())"
Output: [0,1,1,1,1,0]

Example 2:
Input: seq = "()(())()"
Output: [0,0,0,1,1,0,1,1]

*/

/*

Solution 1: greedily distribute the parenthese pairs which is to make two consecutive open parentheses in different groups
            count the number of open parenthese and separate into two groups by whether it's even or odd
            use deque to maintain the group of open parentheses and set the corresponding close parentheses
O(n),O(n)            

*/

public int[] maxDepthAfterSplit(String seq) {
    int n = seq.length(), cnt = 0, i = 0;
    int[] ans = new int[n];
    Deque<Integer> deque = new ArrayDeque<>();
    for (char c : seq.toCharArray()) {
        if (c == '(') {
            if (cnt % 2 == 0) {
                ans[i++] = 0;
                deque.offerLast(0);
            } else {
                ans[i++] = 1;
                deque.offerLast(1);
            }
            cnt++;
        } else {
            ans[i++] = deque.pollLast();
            cnt--;
        }
    }
    return ans;
}


/*

Solution 2: keep two groups balanced with two counts
O(n),O(1)

*/

public int[] maxDepthAfterSplit(String seq) {
    int n = seq.length(), a = 0, b = 0;
    int[] ans = new int[n];
    for (int i = 0; i < n; ++i) {
        if (seq.charAt(i) == '(') {
            if (a < b) {
                a++;
                ans[i] = 0;
            } else {
                b++;
                ans[i] = 1;
            }
        } else {
            if (a < b) {
                b--;
                ans[i] = 1;
            } else {
                a--;
                ans[i] = 0;
            }
        }
    }
    return ans;
}



