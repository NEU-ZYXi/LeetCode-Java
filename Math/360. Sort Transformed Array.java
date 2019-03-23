
/*

Given a sorted array of integers nums and integer values a, b and c. 
Apply a quadratic function of the form f(x) = ax2 + bx + c to each element x in the array.
The returned array must be in sorted order.

Example 1:
Input: nums = [-4,-2,2,4], a = 1, b = 3, c = 5
Output: [3,9,15,33]

Example 2:
Input: nums = [-4,-2,2,4], a = -1, b = 3, c = 5
Output: [-23,-5,1,7]

*/

/*

O(n),O(1)

*/

public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
    int n = nums.length, l = 0, r = n - 1, i = a >= 0 ? n - 1 : 0;
    int[] ans = new int[n];
    while (l <= r) {
        if (a >= 0) {
            int y1 = a * nums[l] * nums[l] + b * nums[l] + c;
            int y2 = a * nums[r] * nums[r] + b * nums[r] + c;
            if (y1 >= y2) {
                ans[i--] = y1;
                l++;
            } else {
                ans[i--] = y2;
                r--;
            }
        } else {
            int y1 = a * nums[l] * nums[l] + b * nums[l] + c;
            int y2 = a * nums[r] * nums[r] + b * nums[r] + c;
            if (y1 >= y2) {
                ans[i++] = y2;
                r--;
            } else {
                ans[i++] = y1;
                l++;
            }
        }
    }
    return ans;
}




