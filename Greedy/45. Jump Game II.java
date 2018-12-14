
/*

Given an array of non-negative integers, you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.
Your goal is to reach the last index in the minimum number of jumps.

Example:
Input: [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2.
    Jump 1 step from index 0 to 1, then 3 steps to the last index.

*/

/*

Solution: from i, we could reach curMax=i+nums[i]
          based on Greedy, we always jump to the furthest with one jump, so when we reach the curEnd, trigger a jump to curMax
O(n),O(1)          

*/

public int jump(int[] nums) {
    int ans = 0, curEnd = 0, curMax = 0;
    for (int i = 0; i < nums.length - 1; ++i) {  // i<nums.length-1, donot need to trigger a jump in the end
        curMax = Math.max(curMax, i + nums[i]);
        if (i == curEnd) {
            curEnd = curMax;
            ans++;
        }
    }
    return ans;
}




