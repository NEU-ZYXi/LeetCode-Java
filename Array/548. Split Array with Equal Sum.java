
/*

Given an array with n integers, you need to find if there are triplets (i, j, k) which satisfies following conditions:
0 < i, i + 1 < j, j + 1 < k < n - 1
Sum of subarrays (0, i - 1), (i + 1, j - 1), (j + 1, k - 1) and (k + 1, n - 1) should be equal.
where we define that subarray (L, R) represents a slice of the original array starting from the element indexed L to the element indexed R.

Example:
Input: [1,2,1,2,1,2,1]
Output: True
Explanation:
i = 1, j = 3, k = 5. 
sum(0, i - 1) = sum(0, 0) = 1
sum(i + 1, j - 1) = sum(2, 2) = 1
sum(j + 1, k - 1) = sum(4, 4) = 1
sum(k + 1, n - 1) = sum(6, 6) = 1

*/

/*

O(n^2),O(n)

*/

public boolean splitArray(int[] nums) {
    int n = nums.length;
    int[] sums = new int[n + 1];
    for (int i = 1; i <= n; ++i) {
        sums[i] += sums[i - 1] + nums[i - 1];
    }
    for (int j = 3; j < n - 3; ++j) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < j - 1; ++i) {
            if (sums[i] == sums[j] - sums[i + 1]) {
                set.add(sums[i]);
            }
        }
        for (int k = j + 2; k < n - 1; ++k) {
            if (sums[n] - sums[k + 1] == sums[k] - sums[j + 1] && set.contains(sums[n] - sums[k + 1])) {
                return true;
            }
        }
    }
    return false;
}





