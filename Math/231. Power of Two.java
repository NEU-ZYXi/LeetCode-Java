
/*

Given an integer, write a function to determine if it is a power of two.

Example 1:
Input: 1
Output: true 
Explanation: 20 = 1

Example 2:
Input: 16
Output: true
Explanation: 24 = 16

Example 3:
Input: 218
Output: false

*/

/*

O(n),O(1)

*/

public boolean isPowerOfTwo(int n) {
    if (n <= 0) return false;
    while (n % 2 == 0) n /= 2;
    return n == 1;
}


/*

Solution 2: n&(n-1) to remove the last set bit, and if it's power of two, there is only one '1' bit, so the remain should be 0
O(1),O(1)

*/

public boolean isPowerOfTwo(int n) {
    if (n <= 0) return false;
    return (n & (n - 1)) == 0;
}



