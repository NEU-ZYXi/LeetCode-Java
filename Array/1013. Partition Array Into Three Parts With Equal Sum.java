
/*

Given an array A of integers, return true if and only if we can partition the array into three non-empty parts with equal sums.
Formally, we can partition the array if we can find indexes i+1 < j with 
(A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1])

Example 1:
Input: [0,2,1,-6,6,-7,9,1,2,0,1]
Output: true
Explanation: 0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1

Example 2:
Input: [0,2,1,-6,6,7,9,-1,2,0,1]
Output: false

Example 3:
Input: [3,3,6,5,-2,2,5,1,-9,4]
Output: true
Explanation: 3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4

*/

/*

O(n),O(1)

*/

public boolean canThreePartsEqualSum(int[] A) {
    int sum = 0, cur = 0, cnt = 0;
    for (int a : A) {
        sum += a;
    }
    if (sum % 3 != 0) {
        return false;
    }
    sum /= 3;
    for (int a : A) {
        cur += a;
        if (cur == sum) {
            cur = 0;
            cnt++;
        }
    }
    return cur == 0 && cnt == 3;
}




