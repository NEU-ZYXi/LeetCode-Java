
/*

Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
Your algorithm's runtime complexity must be in the order of O(log n).
If the target is not found in the array, return [-1, -1].

Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

*/

/*

O(logn),O(1)

*/

public int[] searchRange(int[] nums, int target) {
    int[] ans = new int[] {-1, -1};
    if (nums.length == 0) 
        return ans;
    int l = 0, r = nums.length - 1;
    while (l < r) {
        int m = (l + r) / 2;
        if (nums[m] >= target) r = m;
        else l = m + 1;
    }
    if (nums[l] == target) ans[0] = l;
    else return ans;
    r = nums.length - 1;
    while (l < r) {
        int m = (l + r + 1) / 2;
        if (nums[m] <= target) l = m;
        else r = m - 1;
    }
    if (nums[r] == target) ans[1] = r;
    else return new int[] {-1, -1};
    return ans;
}



