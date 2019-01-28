
/*

Given a positive integer, return its corresponding column title as appear in an Excel sheet.
For example:
    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
    ...
    
Example 1:
Input: 1
Output: "A"

Example 2:
Input: 28
Output: "AB"

Example 3:
Input: 701
Output: "ZY"

*/

/*

O(n),O(1)

*/

public String convertToTitle(int n) {
    StringBuilder ans = new StringBuilder();
    while (n > 0) {
        n--;
        ans.append((char)('A' + n % 26));
        n /= 26;
    }
    ans.reverse();
    return ans.toString();
}




