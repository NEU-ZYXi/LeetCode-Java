
/*

Given a string and an integer k, you need to reverse the first k characters 
for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. 
If there are less than 2k but greater than or equal to k characters, 
then reverse the first k characters and left the other as original.

Example:
Input: s = "abcdefg", k = 2
Output: "bacdfeg"

*/

/*

O(n),O(1)

*/

public String reverseStr(String s, int k) {
    char[] chars = s.toCharArray();
    int n = s.length(), i = 0;
    while (i < n) {
        int j = Math.min(i + k - 1, n - 1);
        reverse(chars, i, j);
        i += 2 * k;
    }
    return new String(chars);
}

private void reverse(char[] chars, int i, int j) {
    while (i < j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
        i++;
        j--;
    }
}




