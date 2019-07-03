
/*

Given a sorted array A of unique numbers, find the K-th missing number starting from the leftmost number of the array.

Example 1:
Input: A = [4,7,9,10], K = 1
Output: 5
Explanation: 
The first missing number is 5.

Example 2:
Input: A = [4,7,9,10], K = 3
Output: 8
Explanation: 
The missing numbers are [5,6,8,...], hence the third missing number is 8.

Example 3:
Input: A = [1,2,4], K = 3
Output: 6
Explanation: 
The missing numbers are [3,5,6,7,...], hence the third missing number is 6.

*/

/*

O(logn),O(1)

*/

public int missingElement(int[] nums, int k) {
    int n = nums.length, l = 0, r = n - 1;
    int cnt = nums[n - 1] - nums[0] + 1 - n;
    if (cnt < k) {
        return nums[n - 1] + k - cnt;
    }
    while (l < r - 1) {
        int mid = (l + r) / 2;
        int missing = nums[mid] - nums[l] + 1 - (mid - l + 1);
        if (missing >= k) {
            r = mid;
        } else {
            l = mid;
            k -= missing;
        }
    }
    return nums[l] + k;
}




