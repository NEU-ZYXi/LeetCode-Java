
/*

Given a column title as appear in an Excel sheet, return its corresponding column number.
For example:
    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
    ...
    
Example 1:
Input: "A"
Output: 1

Example 2:
Input: "AB"
Output: 28

Example 3:
Input: "ZY"
Output: 701

*/

/*

O(n),O(1)

*/

public int titleToNumber(String s) {
    int ans = 0, tmp = 1;
    for (int i = s.length() - 1; i >= 0; --i) {
        ans += (s.charAt(i) - 'A' + 1) * tmp;
        tmp *= 26;
    }
    return ans;
}



