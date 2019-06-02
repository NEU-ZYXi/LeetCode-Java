
/*

Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, 
then the whole array will be sorted in ascending order, too.
You need to find the shortest such subarray and output its length.

Example 1:
Input: [2, 6, 4, 8, 10, 9, 15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.

*/

/*

Solution 1: sort the array and find the mismatch start and end index
O(nlogn),O(n)

*/

public int findUnsortedSubarray(int[] nums) {
    int n = nums.length;
    int[] tmp = Arrays.copyOf(nums, n);
    Arrays.sort(tmp);
    int i = 0, j = n - 1;
    while (i < n && nums[i] == tmp[i]) {
        i++;
    }
    while (i < j && nums[j] == tmp[j]) {
        j--;
    }
    return j - i + 1;
}


/*

Solution 2: find the mismatch subarray, find max and min in that subarray, move back l and r pointers
O(n),O(1)

*/

public int findUnsortedSubarray(int[] nums) {
    int n = nums.length, l = 0, r = n - 1;
    while (l < n - 1 && nums[l] <= nums[l + 1]) {
        l++;
    }
    if (l >= r) {
        return 0;
    }
    while (nums[r] >= nums[r - 1]) {
        r--;
    }
    int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    for (int i = l; i <= r; ++i) {
        max = Math.max(max, nums[i]);
        min = Math.min(min, nums[i]);
    }
    while (l >= 0 && nums[l] > min) {
        l--;
    }
    while (r < n && nums[r] < max) {
        r++;
    }
    return r - l - 1;
}


/*

Solution 3: use two pointers i and j start from beginning and end of array
            for nums[i], if nums[i]!=max(nums[0...i]) which means nums[i] is a mismatch, move r pointer to i index
            for nums[j], if nums[j]!=min(nums[j...]) which means nums[j] is a mismatch, move l pointer to j index
            and finally i and j pointer will point to the two mismatch subarray boundaries
O(n),O(1)            

*/

public int findUnsortedSubarray(int[] nums) {
    int n = nums.length, l = 0, r = -1, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    for (int i = 0, j = n - 1; j >= 0; ++i, --j) {
        max = Math.max(max, nums[i]);
        if (nums[i] != max) {
            r = i;
        }
        min = Math.min(min, nums[j]);
        if (nums[j] != min) {
            l = j;
        }
    }
    return r - l + 1;
}





