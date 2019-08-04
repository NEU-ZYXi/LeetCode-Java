
/*

Given strings S and T, find the minimum (contiguous) substring W of S, so that T is a subsequence of W.
If there is no such window in S that covers all characters in T, return the empty string "". 
If there are multiple such minimum-length windows, return the one with the left-most starting index.

Example 1:
Input: 
S = "abcdebdde", T = "bde"
Output: "bcde"
Explanation: 
"bcde" is the answer because it occurs before "bdde" which has the same length.
"deb" is not a smaller window because the elements of T in the window must occur in order.

*/

/*

Solution: use left and right pointers to maintain a window for string T
          extend right pointer until all the characters in T are found
          left pointer starts from right pointer position, move it back until the first character in T is found
          then we compare window size to find the valid min window
          for the next finding, move right pointer to the right of current left pointer position
O(nm),O(1)          

*/

public String minWindow(String S, String T) {
    String ans = "";
    int min = Integer.MAX_VALUE, n = S.length(), m = T.length();
    int left = 0, right = 0;
    while (right < n) {
        int tIdx = 0;
        while (right < n) {
            if (S.charAt(right) == T.charAt(tIdx)) {
                tIdx++;
            }
            if (tIdx == m) {
                break;
            }
            right++;
        }
        if (right == n) {
            break;
        }
        left = right;
        tIdx = m - 1;
        while (left >= 0) {
            if (S.charAt(left) == T.charAt(tIdx)) {
                tIdx--;
            }
            if (tIdx < 0) {
                break;
            }
            left--;
        }
        if (right - left + 1 < min) {
            min = right - left + 1;
            ans = S.substring(left, right + 1);
        }
        right = left + 1;
    }
    return ans;
}




