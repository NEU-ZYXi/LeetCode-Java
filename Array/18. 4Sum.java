
/*

Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums 
such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:
The solution set must not contain duplicate quadruplets.

Example:
Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]

*/

/*

O(n^3),O(1)

*/

public List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> ans = new ArrayList<>();
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 3; ++i) {
        if (i > 0 && nums[i] == nums[i - 1])
            continue;
        for (int j = i + 1; j < nums.length - 2; ++j) {
            if (j > i + 1 && nums[j] == nums[j - 1])
                continue;
            int l = j + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[j] + nums[l] + nums[r];
                if (sum == target) {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                    l++;
                    r--;
                    while (l < r && nums[l] == nums[l - 1]) l++;
                    while (l < r && nums[r] == nums[r + 1]) r--;
                } else if (sum > target) {
                    r--;
                    while (l < r && nums[r] == nums[r + 1]) r--;
                } else {
                    l++;
                    while (l < r && nums[l] == nums[l - 1]) l++;
                }
            }
        }
    }
    return ans;
}




