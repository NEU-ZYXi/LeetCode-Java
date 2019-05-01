
/*

A sequence of number is called arithmetic if it consists of at least three elements and 
if the difference between any two consecutive elements is the same.

For example, these are arithmetic sequence:
1, 3, 5, 7, 9
7, 7, 7, 7
3, -1, -5, -9
The following sequence is not arithmetic.
1, 1, 2, 5, 7

Example:
A = [1, 2, 3, 4]
return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.

*/

/*

O(n),O(1)

*/

public int numberOfArithmeticSlices(int[] A) {
    int n = A.length, ans = 0, cnt = 0;
    if (n <= 2) return 0;
    for (int i = 2; i < n; ++i) {
        if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) cnt++;
        else cnt = 0;
        ans += cnt;
    }
    return ans;
}




