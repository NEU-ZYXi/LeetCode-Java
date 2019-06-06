
/*

Given an array consists of non-negative integers, your task is to count the number of triplets chosen from the array 
that can make triangles if we take them as side lengths of a triangle.

Example 1:
Input: [2,2,3,4]
Output: 3
Explanation:
Valid combinations are: 
2,3,4 (using the first 2)
2,3,4 (using the second 2)
2,2,3

*/

/*

O(nlogn+n^2),O(1)

*/

public int triangleNumber(int[] nums) {
    int ans = 0;
    Arrays.sort(nums);
    for (int i = 2; i < nums.length; ++i) {
        int l = 0, r = i - 1;
        while (l < r) {
            if (nums[l] + nums[r] > nums[i]) {
                ans += (r - l);
                r--;
            } else {
                l++;
            }
        }
    }
    return ans;
}




