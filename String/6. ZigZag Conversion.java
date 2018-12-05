
/*

The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
(you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:
string convert(string s, int numRows);

Example 1:
Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"

Example 2:
Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I

*/

/*

O(n),O(row)

*/

public String convert(String s, int numRows) {
    if (numRows == 1) return s;
    StringBuilder[] sb = new StringBuilder[numRows];
    for (int i = 0; i < numRows; ++i) 
        sb[i] = new StringBuilder();
    int idx = 0, delta = 1;
    for (int i = 0; i < s.length(); ++i) {
        sb[idx].append(s.charAt(i));
        if (idx == 0) delta = 1;
        if (idx == numRows - 1) delta = -1;
        idx += delta;
    }
    String ans = "";
    for (int i = 0; i < numRows; ++i) 
        ans += sb[i];
    return ans;
}




