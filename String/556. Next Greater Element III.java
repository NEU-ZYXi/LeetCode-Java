
/*

Given a positive 32-bit integer n, you need to find the smallest 32-bit integer 
which has exactly the same digits existing in the integer n and is greater in value than n. 
If no such positive 32-bit integer exists, you need to return -1.

Example 1:
Input: 12
Output: 21
 
Example 2:
Input: 21
Output: -1

*/

/*

O(n),O(n)

*/

public int nextGreaterElement(int num) {
    char[] digits = String.valueOf(num).toCharArray();
    int n = digits.length;
    if (n <= 1) {
        return -1;
    }
    int i = n - 1, j = n - 1;
    while (i > 0) {
        if (digits[i] > digits[i - 1]) {
            break;
        }
        i--;
    }
    if (i == 0) {
        return -1;
    }
    if (i != 0) {
        while (j >= i) {
            if (digits[j] > digits[i - 1]) {
                break;
            }
            j--;
        }
        swap(digits, i - 1, j);
    }
    reverse(digits, i, n - 1);
    int ans = 0;
    for (char c : digits) {
        if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE && c > '7')) {
            return -1;
        }
        ans = ans * 10 + (c - '0');
    }
    return ans;
}

private void swap(char[] chars, int i, int j) {
    char tmp = chars[i];
    chars[i] = chars[j];
    chars[j] = tmp;
}

private void reverse(char[] chars, int i, int j) {
    while (i < j) {
        swap(chars, i, j);
        i++;
        j--;
    }
}




