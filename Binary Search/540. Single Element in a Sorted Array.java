
/*

Given a sorted array consisting of only integers where every element appears exactly twice 
except for one element which appears exactly once. Find this single element that appears only once.

Example 1:
Input: [1,1,2,3,3,4,4,8,8]
Output: 2

Example 2:
Input: [3,3,7,7,10,11,11]
Output: 10

*/

/*

O(logn),O(1)

*/

public int singleNonDuplicate(int[] nums) {
    int n = nums.length, l = 0, r = n - 1;
    while (l < r) {
        int mid = (l + r) / 2;
        if ((mid == n - 1 || nums[mid] != nums[mid + 1]) && (mid == 0 || nums[mid] != nums[mid - 1])) {
            return nums[mid];
        } else if (nums[mid] == nums[mid + 1] && mid % 2 == 0) {
            l = mid + 1;
        } else if (nums[mid] == nums[mid - 1] && mid % 2 == 1) {
            l = mid + 1;
        } else {
            r = mid - 1;
        }
    }
    return nums[l];
}




