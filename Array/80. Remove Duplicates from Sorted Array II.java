
/*

Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice, return the new length.
Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Example 1:
Given nums = [1,1,1,2,2,3],
Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
It doesn't matter what you leave beyond the returned length.

Example 2:
Given nums = [0,0,1,1,1,1,2,3,3],
Your function should return length = 7, with the first seven elements of nums being modified to 0, 0, 1, 1, 2, 3 and 3.
It doesn't matter what values are set beyond the returned length.

*/

/*

O(n),O(1)

*/

public int removeDuplicates(int[] nums) {
    int i = 0;
    for (int num : nums) {
        if (i < 2 || num != nums[i - 2]) nums[i++] = num;
    }
    return i;
}


public int removeDuplicates(int[] nums) {
    int i = 0;
    for (int num : nums) {
        if (i < k || num != nums[i - k]) nums[i++] = num;
    }
    return i;
}




