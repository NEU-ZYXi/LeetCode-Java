
/*

Given a non-negative integer num represented as a string, 
remove k digits from the number so that the new number is the smallest possible.
Note:
The length of num is less than 10002 and will be ≥ k.
The given num does not contain any leading zero.

Example 1:
Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.

Example 2:
Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.

Example 3:
Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.

*/

/*

Solution: remove digits greedily, which means when we have a smaller character, remove all the previous greater ones
O(n),O(n)

*/

public String removeKdigits(String num, int k) {
    int n = num.length();
    if (n == k) return "0";
    char[] cur = new char[n - k];
    for (int i = 0, j = 0; i < n; ++i) {
        while (j > 0 && i - j < k && num.charAt(i) < cur[j - 1]) j--;
        if (j < cur.length) cur[j++] = num.charAt(i);
    }
    String ans = new String(cur);
    while (ans.charAt(0) == '0' && ans.length() > 1) ans = ans.substring(1);
    return ans;
}




