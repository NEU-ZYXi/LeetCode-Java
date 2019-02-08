
/*

Given an array nums of n integers where n > 1,  
return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:
Input:  [1,2,3,4]
Output: [24,12,8,6]

*/

/*

O(n),O(1)

*/

public int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] ans = new int[n];
    for (int i = 0, tmp = 1; i < n; ++i) {
        ans[i] = tmp;
        tmp *= nums[i];
    }
    for (int i = n - 1, tmp = 1; i >= 0; --i) {
        ans[i] *= tmp;
        tmp *= nums[i];
    }
    return ans;
}



