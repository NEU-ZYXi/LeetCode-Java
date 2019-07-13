
/*

Given an array A of positive integers, let S be the sum of the digits of the minimal element of A.
Return 0 if S is odd, otherwise return 1.

Example 1:
Input: [34,23,1,24,75,33,54,8]
Output: 0
Explanation: 
The minimal element is 1, and the sum of those digits is S = 1 which is odd, so the answer is 0.

Example 2:
Input: [99,77,33,66,55]
Output: 1
Explanation: 
The minimal element is 33, and the sum of those digits is S = 3 + 3 = 6 which is even, so the answer is 1.

*/

/*

O(n),O(1)

*/

public int sumOfDigits(int[] A) {
    int ans = 0, min = Integer.MAX_VALUE;
    for (int a : A) {
        min = Math.min(min, a);
    }
    while (min != 0) {
        ans += min % 10;
        min /= 10;
    }
    return ans % 2 == 0 ? 1 : 0;
}



