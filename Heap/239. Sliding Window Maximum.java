
/*

Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. 
You can only see the k numbers in the window. Each time the sliding window moves right by one position. 
Return the max sliding window.

Example:
Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
Output: [3,3,5,5,6,7] 
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7

*/

/*

Solution: use a deque to maintain the maximum of the current window
          if deque[first]<i-k+1, which means the window moves to right, pollFirst()
          while nums[deque[last]]<nums[i] then pollLast(), so all the previous elements in the window have nums[i] as maximum
O(n),O(n)          

*/

public int[] maxSlidingWindow(int[] nums, int k) {
    int n = nums.length;
    int[] ans = new int[n - k + 1];
    if (k <= 0) return new int[0];
    Deque<Integer> deque = new LinkedList<>();
    for (int i = 0; i < n; ++i) {
        if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) deque.pollFirst();
        while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) deque.pollLast();
        deque.offerLast(i);
        if (i - k + 1 >= 0) ans[i - k + 1] = nums[deque.peekFirst()];
    }
    return ans;
}




