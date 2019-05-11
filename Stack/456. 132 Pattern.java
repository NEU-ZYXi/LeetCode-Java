
/*

Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a subsequence ai, aj, ak such that i < j < k and ai < ak < aj. 
Design an algorithm that takes a list of n numbers as input and checks whether there is a 132 pattern in the list.

Example 1:
Input: [1, 2, 3, 4]
Output: False
Explanation: There is no 132 pattern in the sequence.

Example 2:
Input: [3, 1, 4, 2]
Output: True
Explanation: There is a 132 pattern in the sequence: [1, 4, 2].

Example 3:
Input: [-1, 3, 2, 0]
Output: True
Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].

*/

/*

O(n),O(n)

*/

public boolean find132pattern(int[] nums) {
    int second = Integer.MIN_VALUE;
    Deque<Integer> deque = new ArrayDeque<>();
    for (int i = nums.length - 1; i >= 0; --i) {
        if (nums[i] < second) return true;
        while (!deque.isEmpty() && nums[i] > deque.peekLast()) second = deque.pollLast(); 
        deque.offerLast(nums[i]);
    }
    return false;
}





