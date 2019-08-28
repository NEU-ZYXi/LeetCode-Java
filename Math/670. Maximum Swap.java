
/*

Given a non-negative integer, you could swap two digits at most once to get the maximum valued number. 
Return the maximum valued number you could get.

Example 1:
Input: 2736
Output: 7236
Explanation: Swap the number 2 and the number 7.

Example 2:
Input: 9973
Output: 9973
Explanation: No swap.

*/

/*

O(n),O(n)

*/

public int maximumSwap(int num) {
    char[] digits = String.valueOf(num).toCharArray();
    int[] buckets = new int[10];
    int n = digits.length;
    for (int i = 0; i < n; ++i) {
        buckets[digits[i] - '0'] = i;
    }
    for (int i = 0; i < n; ++i) {
        for (int j = 9; j > digits[i] - '0'; --j) {
            if (buckets[j] > i) {
                char tmp = digits[i];
                digits[i] = digits[buckets[j]];
                digits[buckets[j]] = tmp;
                return Integer.valueOf(new String(digits));
            }
        }
    }
    return num;
}




