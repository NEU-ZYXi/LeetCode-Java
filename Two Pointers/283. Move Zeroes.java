
/*

Given an array nums, write a function to move all 0's to the end of it while maintaining the order of the other elements.

Example:
Input: [0,1,0,3,12]
Output: [1,3,12,0,0]

*/

/*

O(n),O(1)

*/

public void moveZeroes(int[] nums) {
    int i = 0;
    for (int num : nums) {
        if (num != 0) nums[i++] = num;
    }
    while (i < nums.length) nums[i++] = 0;
}



