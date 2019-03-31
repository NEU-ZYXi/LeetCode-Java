
/*

Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

Example 1:
Input: a = 1, b = 2
Output: 3

Example 2:
Input: a = -2, b = 3
Output: 1

*/

/*

Solution: a^b to sum up the different bits, (a&b)<<1 to get the bits which are carry bits and add them together recursively
O(1),O(1)

*/

public int getSum(int a, int b) {
    return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
}




