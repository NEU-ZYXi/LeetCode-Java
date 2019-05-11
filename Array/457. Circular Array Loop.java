
/*

You are given a circular array nums of positive and negative integers. 
If a number k at an index is positive, then move forward k steps. Conversely, if it's negative (-k), move backward k steps. 
Since the array is circular, you may assume that the last element's next element is the first element, 
and the first element's previous element is the last element.
Determine if there is a loop (or a cycle) in nums. A cycle must start and end at the same index and the cycle's length > 1. 
Furthermore, movements in a cycle must all follow a single direction. 
In other words, a cycle must not consist of both forward and backward movements.

Example 1:
Input: [2,-1,1,2,2]
Output: true
Explanation: There is a cycle, from index 0 -> 2 -> 3 -> 0. The cycle's length is 3.

Example 2:
Input: [-1,2]
Output: false
Explanation: The movement from index 1 -> 1 -> 1 ... is not a cycle, because the cycle's length is 1. 
By definition the cycle's length must be greater than 1.

Example 3:
Input: [-2,1,-1,-2,-2]
Output: false
Explanation: The movement from index 1 -> 2 -> 1 -> ... is not a cycle, 
because movement from index 1 -> 2 is a forward movement, but movement from index 2 -> 1 is a backward movement. 
All movements in a cycle must follow a single direction.

*/

/*

Solution: like finding a circle in linked list, use fast and slow pointers to jump over the array until they meet
O(n),O(1)

*/

public boolean circularArrayLoop(int[] nums) {
    int n = nums.length;
    if (n <= 1) return false;
    for (int i = 0; i < n; ++i) {
        if (nums[i] == 0) continue;
        int slow = i, fast = getIndex(nums, i);
        while (nums[i] * nums[fast] > 0 && nums[i] * nums[getIndex(nums, fast)] > 0) {
            if (fast == slow) {
                if (slow == getIndex(nums, slow)) break;
                return true;
            }
            slow = getIndex(nums, slow);
            fast = getIndex(nums, getIndex(nums, fast));
        }
        int cur = i;
        while (nums[i] * nums[cur] > 0) {
            int nxt = getIndex(nums, cur);
            nums[cur] = 0;
            cur = nxt;
        }
    }
    return false;
}

private int getIndex(int[] nums, int i) {
    int n = nums.length;
    return i + nums[i] >= 0 ? (i + nums[i]) % n : n + (i + nums[i]) % n;
}





