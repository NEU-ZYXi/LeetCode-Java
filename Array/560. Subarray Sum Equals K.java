
/*

Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:
Input:nums = [1,1,1], k = 2
Output: 2

*/

/*

Solution: use prefix sum, when we have a sum for nums[j] and sum-k for nums[i] which means nums[i...j] is k
O(n),O(n)          

*/

public int subarraySum(int[] nums, int k) {
    int ans = 0, sum = 0;
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);
    for (int num : nums) {
        sum += num;
        if (map.containsKey(sum - k)) {
            ans += map.get(sum - k);
        }
        map.put(sum, map.getOrDefault(sum, 0) + 1);
    }
    return ans;
}




