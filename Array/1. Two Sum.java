
/*

Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

*/

/* 

Solution 1
O(n),O(n)

*/
public int[] twoSum(int[] nums, int target) {
    int[] ans = new int[2];
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; ++i) {
        if (map.containsKey(nums[i])) {
            ans[0] = map.get(nums[i]);
            ans[1] = i;
            break;
        }
        map.put(target - nums[i], i);
    }
    return ans;
}


/* 

Solution 2
O(n^2),O(1)

*/
public int[] twoSum(int[] nums, int target) {
    int[] ans = new int[2];
    for (int i = 0; i < nums.length; ++i) {
        for (int j = i + 1; j < nums.length; ++j) {
            if (nums[i] + nums[j] == target) {
                ans[0] = i;
                ans[1] = j;
                return ans;
            }
        }
    }
    return ans;
}




