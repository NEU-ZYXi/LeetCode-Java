
/*

Given an array nums of integers, a move consists of choosing any element and decreasing it by 1.
An array A is a zigzag array if either:
Every even-indexed element is greater than adjacent elements, ie. A[0] > A[1] < A[2] > A[3] < A[4] > ...
OR, every odd-indexed element is greater than adjacent elements, ie. A[0] < A[1] > A[2] < A[3] > A[4] < ...
Return the minimum number of moves to transform the given array nums into a zigzag array.

Example 1:
Input: nums = [1,2,3]
Output: 2
Explanation: We can decrease 2 to 0 or 3 to 1.

Example 2:
Input: nums = [9,6,1,6,2]
Output: 4

*/

/*

O(n),O(1)

*/

public int movesToMakeZigzag(int[] nums) {
    int n = nums.length, even = 0, odd = 0;
    for (int i = 0; i < n; i += 2) {
        int left = i > 0 ? nums[i - 1] : Integer.MAX_VALUE;
        int right = i + 1 < n ? nums[i + 1] : Integer.MAX_VALUE;
        int min = Math.min(left, right);
        if (nums[i] >= min) {
            odd += nums[i] - min + 1;
        }
    }
    for (int i = 1; i < n; i += 2) {
        int left = nums[i - 1];
        int right = i + 1 < n ? nums[i + 1] : Integer.MAX_VALUE;
        int min = Math.min(left, right);
        if (nums[i] >= min) {
            even += nums[i] - min + 1;
        }
    }
    return Math.min(odd, even);
}



