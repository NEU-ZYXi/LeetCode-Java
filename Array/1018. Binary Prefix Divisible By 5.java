
/*

Given an array A of 0s and 1s, consider N_i: the i-th subarray from A[0] to A[i] interpreted as a binary number 
(from most-significant-bit to least-significant-bit.)
Return a list of booleans answer, where answer[i] is true if and only if N_i is divisible by 5.

Example 1:
Input: [0,1,1]
Output: [true,false,false]
Explanation: 
The input numbers in binary are 0, 01, 011; which are 0, 1, and 3 in base-10.  
Only the first number is divisible by 5, so answer[0] is true.

Example 2:
Input: [1,1,1]
Output: [false,false,false]

Example 3:
Input: [0,1,1,1,1,1]
Output: [true,false,false,false,true,false]

Example 4:
Input: [1,1,1,0,1]
Output: [false,false,false,false,false]

*/

/*

Solution: because (ab+c)%k=((a%k)(b%k)+c%k)%k, so new_number%5=((old_number%5)*2+A[i])%5, then let number%5 as a whole
O(n),O(n)

*/

public List<Boolean> prefixesDivBy5(int[] A) {
    List<Boolean> ans = new ArrayList<>();
    int cur = 0;
    for (int a : A) {
        cur = ((cur << 1) + a) % 5;
        ans.add(cur == 0);
    }
    return ans;
}



