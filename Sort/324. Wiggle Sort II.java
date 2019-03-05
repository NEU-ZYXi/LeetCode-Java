
/*

Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

Example 1:
Input: nums = [1, 5, 1, 1, 6, 4]
Output: One possible answer is [1, 4, 1, 5, 1, 6].

Example 2:
Input: nums = [1, 3, 2, 2, 3, 1]
Output: One possible answer is [2, 3, 1, 3, 1, 2].

*/

/*

Solution 1: sort the array and find the middle element, reorder to get wiggle sort
O(nlogn),O(n)

*/

public void wiggleSort(int[] nums) {
    Arrays.sort(nums);
    int n = nums.length, mid = n % 2 == 0 ? n / 2 - 1 : n / 2;
    int[] tmp = Arrays.copyOf(nums, n);
    int idx = 0;
    for (int i = 0; i <= mid; ++i) {
        nums[idx] = tmp[mid - i];
        if (idx + 1 < n) nums[idx + 1] = tmp[n - i - 1];
        idx += 2;
    }
}




