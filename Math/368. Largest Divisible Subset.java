
/*

Given a set of distinct positive integers, 
find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies:
Si % Sj = 0 or Sj % Si = 0.
If there are multiple solutions, return any subset is fine.

Example 1:
Input: [1,2,3]
Output: [1,2] (of course, [1,3] will also be ok)

Example 2:
Input: [1,2,4,8]
Output: [1,2,4,8]

*/

/*

Solution: dp[i] means the longest divisible subset of nums[0...i], use prev[] to track the elements inside subset
          dp[i]=max(dp[j]+1) for 0<=j<i if nums[i]%nums[j]==0, when the array is sorted
          find the longest divisble subset and track the last element on the fly, then print the path
O(nlogn+n^2),O(n)          

*/

public List<Integer> largestDivisibleSubset(int[] nums) {
    List<Integer> ans = new ArrayList<>();
    Arrays.sort(nums);
    int n = nums.length, max = 0, cur = -1;
    int[] dp = new int[n];
    int[] prev = new int[n];
    Arrays.fill(dp, 1);
    Arrays.fill(prev, -1);
    for (int i = 0; i < n; ++i) {
        for (int j = i - 1; j >= 0; --j) {
            if (nums[i] % nums[j] == 0) {
                if (dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
        }
        if (dp[i] > max) {
            max = dp[i];
            cur = i;
        }
    }
    while (cur != -1) {
        ans.add(nums[cur]);
        cur = prev[cur];
    }
    return ans;
}




