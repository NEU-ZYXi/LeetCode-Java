
/*

Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example 1:
Input: 16
Output: true

Example 2:
Input: 5
Output: false

*/

/*

Solution: 4^n must be larger than 0, it's also 2^2n which means there is only one '1' bit, and the bit should be in odd place
O(1),O(1)

*/

public boolean isPowerOfFour(int num) {
    return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) != 0;
}




