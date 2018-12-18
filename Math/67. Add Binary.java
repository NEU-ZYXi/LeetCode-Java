
/*

Given two binary strings, return their sum (also a binary string).
The input strings are both non-empty and contains only characters 1 or 0.

Example 1:
Input: a = "11", b = "1"
Output: "100"

Example 2:
Input: a = "1010", b = "1011"
Output: "10101"

*/

/*

O(n+m),O(1)

*/

public String addBinary(String a, String b) {
    StringBuilder ans = new StringBuilder();
    int n = a.length(), m = b.length(), sum = 0;
    while (n > 0 || m > 0) {
        sum /= 2;
        if (n > 0) {
            sum += a.charAt(n - 1) - '0';
            n--;
        }
        if (m > 0) {
            sum += b.charAt(m - 1) - '0';
            m--;
        }
        ans.append(sum % 2);
    }
    if (sum >= 2) ans.append("1");
    return ans.reverse().toString();
}




