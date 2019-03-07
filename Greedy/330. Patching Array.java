
/*

Given a sorted positive integer array nums and an integer n, 
add/patch elements to the array such that any number in range [1, n] can be formed by the sum of some elements in the array. 
Return the minimum number of patches required.

Example 1:
Input: nums = [1,3], n = 6
Output: 1 
Explanation:
Combinations of nums are [1], [3], [1,3], which form possible sums of: 1, 3, 4.
Now if we add/patch 2 to nums, the combinations are: [1], [2], [3], [1,3], [2,3], [1,2,3].
Possible sums are 1, 2, 3, 4, 5, 6, which now covers the range [1, 6].
So we only need 1 patch.

Example 2:
Input: nums = [1,5,10], n = 20
Output: 2
Explanation: The two patches can be [2, 4].

Example 3:
Input: nums = [1,2,2], n = 5
Output: 0

*/

/*

Solution: let cur be the least missing sum, which means we could use nums[0...i-1] to form [1...cur)
          for nums[i], if it's smaller than cur, which means we could use nums[i] to form [1...cur+nums[i])
          otherwise, we need one more element to cover the gap of sums, which is cur itself based on greedy thought
          so, we could use nums[0...i-1] and cur to form [1...cur+cur)
O(max(n,m)),O(1), where n is the sum n and m is the length of nums array          

*/

public int minPatches(int[] nums, int n) {
    long cur = 1;
    int i = 0, ans = 0;
    while (cur <= n) {
        if (i < nums.length && nums[i] <= cur) {
            cur += nums[i];
            i++;
        } else {
            cur += cur;
            ans++;
        }
    }
    return ans;
}




