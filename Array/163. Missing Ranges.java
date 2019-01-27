
/*

Given a sorted integer array nums, where the range of elements are in the inclusive range [lower, upper], 
return its missing ranges.

Example:
Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
Output: ["2", "4->49", "51->74", "76->99"]

*/

/*

O(n),O(1)

*/

public List<String> findMissingRanges(int[] nums, int lower, int upper) {
    List<String> ans = new ArrayList<>();
    int n = nums.length;
    if (n == 0) {
        ans.add(lower + (lower == upper ? "" : "->" + upper));
        return ans;
    }
    if (lower != Integer.MAX_VALUE && nums[0] != lower) 
        ans.add(lower + (lower == nums[0] - 1 ? "" : "->" + (nums[0] - 1)));
    for (int i = 1; i < n; ++i) {
        if (nums[i - 1] != Integer.MAX_VALUE && nums[i] != nums[i - 1] + 1) {
            if (nums[i] == nums[i - 1] + 2) ans.add(nums[i - 1] + 1 + "");
            if (nums[i] > nums[i - 1] + 2) ans.add(nums[i - 1] + 1 + "->" + (nums[i] - 1));
        }
    }
    if (nums[n - 1] != Integer.MAX_VALUE && nums[n - 1] != upper) 
        ans.add(nums[n - 1] + 1 + (upper == nums[n - 1] + 1 ? "" : "->" + upper));
    return ans;
}




