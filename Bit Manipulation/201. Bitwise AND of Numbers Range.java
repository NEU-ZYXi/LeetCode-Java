
/*

Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

Example 1:
Input: [5,7]
Output: 4

Example 2:
Input: [0,1]
Output: 0

*/

/*

Solution: if m!=n, the last bit AND always has 0&1=0
          m>>1 and n>>1 to check the next bit until m=n
O(32),O(1)

*/

public int rangeBitwiseAnd(int m, int n) {
    int i = 0;
    while (m != n) {
        m >>= 1;
        n >>= 1;
        i++;
    }
    return m << i;
}




