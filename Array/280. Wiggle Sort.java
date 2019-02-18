
/*

Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....

Example:
Input: nums = [3,5,2,1,6,4]
Output: One possible answer is [3,5,1,6,2,4]

*/

/*

Solution 1: sort the array, rearrange the order of elements
O(nlogn),O(1)

*/

public void wiggleSort(int[] nums) {
    Arrays.sort(nums);
    for (int i = 1; i < nums.length - 1; i += 2) swap(nums, i, i + 1);
}

private void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
}


/*

Solution 2: for even index, swap to make nums[i]<nums[i-1]; for odd index, swap to make nums[i]>nums[i-1]
            for nums[0...i], if nums[i+1] not in order, swap can make nums[0...i+1] in wiggle order
O(n),O(1)            

*/

public void wiggleSort(int[] nums) {
    for (int i = 0; i < nums.length; ++i) {
        if (i % 2 == 0) {
            if (i > 0 && nums[i] > nums[i - 1]) swap(nums, i, i - 1);
        } else {
            if (nums[i] < nums[i - 1]) swap(nums, i, i - 1);
        }
    }
}

private void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
}



