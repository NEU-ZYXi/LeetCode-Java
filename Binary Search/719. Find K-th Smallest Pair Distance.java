
/*

Given an integer array, return the k-th smallest distance among all the pairs. 
The distance of a pair (A, B) is defined as the absolute difference between A and B.

Example 1:
Input:
nums = [1,3,1]
k = 1
Output: 0 
Explanation:
Here are all the pairs:
(1,3) -> 2
(1,1) -> 0
(3,1) -> 2
Then the 1st smallest distance pair is (1,1), and its distance is 0.

*/

/*

Solution: binary search in [min,max] range of distances of each pair
          for each candidate distance mid, count the number of distance less than mid and then shrink the search range
O(nlogn),O(1)          

*/

public int smallestDistancePair(int[] nums, int k) {
    int n = nums.length;
    Arrays.sort(nums);
    int low = nums[1] - nums[0], high = nums[n - 1] - nums[0];
    for (int i = 1; i < n - 1; ++i) {
        low = Math.min(low, nums[i + 1] - nums[i]);
    }
    while (low < high) {
        int mid = (low + high) / 2;
        int cnt = countPairs(nums, mid);
        if (cnt < k) {
            low = mid + 1;
        } else {
            high = mid;
        }
    }
    return low;
}

private int countPairs(int[] nums, int target) {
    int n = nums.length, ans = 0;
    for (int i = 0, j = 1; i < n; ++i) {
        while (j < n && nums[j] - nums[i] <= target) {
            j++;
        }
        ans += j - i - 1;
    }
    return ans;
}




