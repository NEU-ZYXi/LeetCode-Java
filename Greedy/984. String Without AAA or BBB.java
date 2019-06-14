
/*

Given two integers A and B, return any string S such that:
S has length A + B and contains exactly A 'a' letters, and exactly B 'b' letters;
The substring 'aaa' does not occur in S;
The substring 'bbb' does not occur in S.
 
Example 1:
Input: A = 1, B = 2
Output: "abb"
Explanation: "abb", "bab" and "bba" are all correct answers.

Example 2:
Input: A = 4, B = 1
Output: "aabaa"

*/

/*

Solution: greedily append the more character
O(n),O(n)

*/

public String strWithout3a3b(int A, int B) {
    StringBuilder ans = new StringBuilder();
    while (A + B > 0) {
        int l = ans.length();
        if (l > 1 && ans.charAt(l - 1) == ans.charAt(l - 2)) {
            if (ans.charAt(l - 1) == 'a') {
                ans.append('b');
                B--;
            } else {
                ans.append('a');
                A--;
            }
        } else {
            if (A > B) {
                ans.append('a');
                A--;
            } else {
                ans.append('b');
                B--;
            }
        }
    }
    return ans.toString();
}




