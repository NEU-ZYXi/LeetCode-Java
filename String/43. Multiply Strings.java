
/*

Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Example 1:
Input: num1 = "2", num2 = "3"
Output: "6"

Example 2:
Input: num1 = "123", num2 = "456"
Output: "56088"

*/

/*

O(nm),O(n+m)

*/

public String multiply(String num1, String num2) {
    int n = num1.length(), m = num2.length();
    int[] pos = new int[n + m];
    for (int i = n - 1; i >= 0; --i) {
        for (int j = m - 1; j >= 0; --j) {
            int p1 = i + j, p2 = i + j + 1;
            int prod = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            int sum = prod + pos[p2];
            pos[p2] = sum % 10;
            pos[p1] += sum / 10;
        }
    }
    StringBuilder ans = new StringBuilder();
    for (int i = 0; i < pos.length; ++i) {
        if (pos[i] > 0 || ans.length() > 0) ans.append(pos[i]);
    }
    return ans.length() == 0 ? "0" : ans.toString();
}



