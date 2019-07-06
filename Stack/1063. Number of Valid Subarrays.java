
/*

Given an array A of integers, return the number of non-empty continuous subarrays that satisfy the following condition:
The leftmost element of the subarray is not larger than other elements in the subarray.

Example 1:
Input: [1,4,2,5,3]
Output: 11
Explanation: There are 11 valid subarrays: [1],[4],[2],[5],[3],[1,4],[2,5],[1,4,2],[2,5,3],[1,4,2,5],[1,4,2,5,3].

Example 2:
Input: [3,2,1]
Output: 3
Explanation: The 3 valid subarrays are: [3],[2],[1].

Example 3:
Input: [2,2,2]
Output: 6
Explanation: There are 6 valid subarrays: [2],[2],[2],[2,2],[2,2],[2,2,2].

*/

/*

Solution: when we have a smaller number, it can be formed with all the numbers previously in the deque
O(n),O(n)

*/

public int validSubarrays(int[] nums) {
    int ans = 0;
    Deque<Integer> deque = new ArrayDeque<>();
    for (int num : nums) {
        while (!deque.isEmpty() && deque.peekLast() > num) {
            deque.pollLast();
        }
        deque.offerLast(num);
        ans += deque.size();
    }
    return ans;
}




