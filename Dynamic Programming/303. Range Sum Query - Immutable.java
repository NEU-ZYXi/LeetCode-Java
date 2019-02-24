
/*

Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]
sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3

*/

/*

O(n),O(n)

*/

class NumArray {
    
    private int[] sums;

    public NumArray(int[] nums) {
        int n = nums.length;
        this.sums = new int[n + 1];
        for (int i = 1; i <= n; ++i) this.sums[i] = this.sums[i - 1] + nums[i - 1];
    }
    
    public int sumRange(int i, int j) {
        return sums[j + 1] - sums[i];
    }
}




