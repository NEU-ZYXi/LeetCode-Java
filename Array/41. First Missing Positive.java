
/*

Given an unsorted integer array, find the smallest missing positive integer.

Example 1:
Input: [1,2,0]
Output: 3

Example 2:
Input: [3,4,-1,1]
Output: 2

Example 3:
Input: [7,8,9,11,12]
Output: 1

*/

/*

O(n),O(1)

*/

public int firstMissingPositive(int[] nums) {
    int i = 0, n = nums.length;
    if (n == 0)
        return 1;
    while (i < nums.length) {
        if (0 <= nums[i] && nums[i] < n && nums[i] != nums[nums[i]]) swap(nums, i, nums[i]);
        else i++;
    }
    int ans = 1;
    while (ans < n && nums[ans] == ans) ans++;
    return nums[0] == ans ? ans + 1 : ans;
}

private void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
}




