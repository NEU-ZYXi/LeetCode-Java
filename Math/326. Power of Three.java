
/*

Given an integer, write a function to determine if it is a power of three.

Example 1:
Input: 27
Output: true

Example 2:
Input: 0
Output: false

Example 3:
Input: 9
Output: true

Example 4:
Input: 45
Output: false

*/

/*

Solution 1: use loop
O(n),O(1)

*/

public boolean isPowerOfThree(int n) {
    if (n == 0) return false;
    while (n % 3 == 0) n /= 3;
    return n == 1;
}


/*

Solution 2: 3^x=n,x=log3(n)=log10(n)/log10(3) which should be an integer
O(1),O(1)

*/

public boolean isPowerOfThree(int n) {
    return (Math.log10(n) / Math.log10(3)) % 1 == 0;
}



