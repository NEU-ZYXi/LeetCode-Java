
/*

Your are given an array of positive integers nums.
Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is less than k.

Example 1:
Input: nums = [10, 5, 2, 6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.

*/

/*

Solution: use two pointers to maintain a window which has total product less than k
          in the window nums[i...j], there are j-i+1 possible subarrays with nums[i] as the first element
O(n),O(1)          

*/

public int numSubarrayProductLessThanK(int[] nums, int k) {
    if (k <= 1) {
        return 0;
    }
    int prod = 1, ans = 0, n = nums.length;
    for (int i = 0, j = 0; j < n; ++j) {
        prod *= nums[j];
        while (prod >= k) {
            prod /= nums[i];
            i++;
        }
        ans += j - i + 1;
    }
    return ans;
}




