
/*

Given a list of non-negative numbers and a target integer k, 
write a function to check if the array has a continuous subarray of size at least 2 that sums up to the multiple of k, 
that is, sums up to n*k where n is also an integer.

Example 1:
Input: [23, 2, 4, 6, 7],  k=6
Output: True
Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.

Example 2:
Input: [23, 2, 6, 4, 7],  k=6
Output: True
Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.

*/

/*

Solution 1: use prefix sum to check each subarray sum
O(n^2),O(n)

*/

public boolean checkSubarraySum(int[] nums, int k) {
    int n = nums.length;
    int[] sums = new int[n];
    sums[0] = nums[0];
    for (int i = 1; i < n; ++i) {
        sums[i] = sums[i - 1] + nums[i];
    }
    for (int i = 0; i < n - 1; ++i) {
        for (int j = i + 1; j < n; ++j) {
            int sum = sums[j] - sums[i] + nums[i];
            if (sum == k || (k != 0 && sum % k == 0)) {
                return true;
            }
        }
    }
    return false;
}


/*

Solution 2: since (sum+n*k)%k=sum%k, keep summing up, whenever we find a same remainder which means the subarray between is valid
O(n),O(n)

*/

public boolean checkSubarraySum(int[] nums, int k) {
    int sum = 0;
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, -1);
    for (int i = 0; i < nums.length; ++i) {
        sum += nums[i];
        if (k != 0) {
            sum %= k;
        }
        if (map.containsKey(sum)) {
            if (i - map.get(sum) > 1) {
                return true;
            } 
        } else {
            map.put(sum, i);
        }
    }
    return false;
}





