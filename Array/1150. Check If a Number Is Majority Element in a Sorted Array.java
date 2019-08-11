
/*

Given an array nums sorted in non-decreasing order, and a number target, 
return True if and only if target is a majority element.
A majority element is an element that appears more than N/2 times in an array of length N.

Example 1:
Input: nums = [2,4,5,5,5,5,5,6,6], target = 5
Output: true
Explanation: 
The value 5 appears 5 times and the length of the array is 9.
Thus, 5 is a majority element because 5 > 9/2 is true.

Example 2:
Input: nums = [10,100,101,101], target = 101
Output: false
Explanation: 
The value 101 appears 2 times and the length of the array is 4.
Thus, 101 is not a majority element because 2 > 4/2 is false.

*/

/*

O(logn),O(1)

*/

public boolean isMajorityElement(int[] nums, int target) {
    int n = nums.length, l = 0, r = n - 1, start = -1, end = -1;
    while (l <= r) {
        int mid = (l + r) / 2;
        if (nums[mid] >= target) {
            start = mid;
            r = mid - 1;
        } else {
            l = mid + 1;
        } 
    }
    if (start == -1) {
        return false;
    }
    l = 0;
    r = n - 1;
    while (l <= r) {
        int mid = (l + r) / 2;
        if (nums[mid] <= target) {
            end = mid;
            l = mid + 1;
        } else {
            r = mid - 1;
        }
    }
    return end - start + 1 > n / 2;
}




