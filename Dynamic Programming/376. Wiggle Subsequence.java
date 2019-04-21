
/*

a wiggle sequence is the differences between successive numbers strictly alternate between positive and negative. 
The first difference (if one exists) may be either positive or negative. 
A sequence with fewer than two elements is trivially a wiggle sequence.
For example, [1,7,4,9,2,5] is a wiggle sequence because the differences (6,-3,5,-7,3) are alternately positive and negative. 
In contrast, [1,4,7,2,5] and [1,7,4,5,5] are not wiggle sequences, 
the first because its first two differences are positive and the second because its last difference is zero.
Given a sequence of integers, return the length of the longest subsequence that is a wiggle sequence. 
A subsequence is obtained by deleting some number of elements (eventually, also zero) from the original sequence, 
leaving the remaining elements in their original order.

Example 1:
Input: [1,7,4,9,2,5]
Output: 6
Explanation: The entire sequence is a wiggle sequence.

Example 2:
Input: [1,17,5,10,13,15,10,5,16,8]
Output: 7
Explanation: There are several subsequences that achieve this length. One is [1,17,10,13,10,16,8].

Example 3:
Input: [1,2,3,4,5,6,7,8,9]
Output: 2

*/

/*

Solution: up[i] means the max length of subsequence where the last two elements are nums[i]>nums[i-1]
          down[i] means the max length of subsequence where the last two elements are nums[i]<nums[i-1]
          up[i]=down[i-1]+1 if nums[i]>nums[i-1]
          down[i]=up[i-1]+1 if nums[i]<nums[i-1]
          otherwise, up[i]=up[i-1], down[i]=down[i-1]

*/

public int wiggleMaxLength(int[] nums) {
    int n = nums.length;
    if (n == 0) return 0;
    int[] up = new int[n];
    int[] down = new int[n];
    up[0] = down[0] = 1;
    for (int i = 1; i < n; ++i) {
        if (nums[i] > nums[i - 1]) {
            up[i] = down[i - 1] + 1;
            down[i] = down[i - 1];
        } else if (nums[i] < nums[i - 1]) {
            up[i] = up[i - 1];
            down[i] = up[i - 1] + 1;
        } else {
            up[i] = up[i - 1];
            down[i] = down[i - 1];
        }
    }
    return Math.max(up[n - 1], down[n - 1]);
}




