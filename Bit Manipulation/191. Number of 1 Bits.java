
/*

Write a function that takes an unsigned integer and return the number of '1' bits it has (also known as the Hamming weight).

Example 1:
Input: 00000000000000000000000000001011
Output: 3
Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.

Example 2:
Input: 00000000000000000000000010000000
Output: 1
Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.

Example 3:
Input: 11111111111111111111111111111101
Output: 31
Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits.

*/

/*

Solution 1: check each bit
O(32),O(1)

*/

public int hammingWeight(int n) {
    int ans = 0;
    for (int i = 0; i < 32; ++i) ans += (n >> i) & 1;
    return ans;
}


/*

Solution 2: remove the last bit set each time, n-1 means convert xxx1000 to xxx0111, n&(n-1) means xxx0000
O(k),O(1), where k is the number of 1 bits

*/

public int hammingWeight(int n) {
    int ans = 0;
    while (n != 0) {
        ans++;
        n &= (n - 1);
    }
    return ans;
}



