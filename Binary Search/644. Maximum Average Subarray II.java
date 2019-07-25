
/*

Given an array consisting of n integers, find the contiguous subarray whose length is greater than or equal to k 
that has the maximum average value.
And you need to output the maximum average value.

Example 1:
Input: [1,12,-5,-6,50,3], k = 4
Output: 12.75
Explanation:
when length is 5, maximum average value is 10.8,
when length is 6, maximum average value is 9.16667.
Thus return 12.75.

*/

/*

Solution: binary search to find the average in [min,max]
          for each candidate, build a new array with elements' value-average
          accumulate the current sum with more than k elements to check whether current sum is larger than 0
O(nlog(max-min)),O(n)          

*/

public double findMaxAverage(int[] nums, int k) {
    double l = Integer.MAX_VALUE, r = Integer.MIN_VALUE;
    for (int num : nums) {
        l = Math.min(l, num);
        r = Math.max(r, num);
    }
    while (r - l > 0.00001) {
        double mid = (l + r) / 2;
        if (check(nums, k, mid)) {
            l = mid;
        } else {
            r = mid;
        }
    }
    return r;
}

private boolean check(int[] nums, int k, double avg) {
    int n = nums.length;
    double cur = 0, prev = 0;
    double[] a = new double[n];
    for (int i = 0; i < n; ++i) {
        a[i] = nums[i] - avg;
    }
    for (int i = 0; i < k; ++i) {
        cur += a[i];
    }
    if (cur >= 0) {
        return true;
    }
    for (int i = k; i < n; ++i) {
        cur += a[i];
        prev += a[i - k];
        if (prev < 0) {
            cur -= prev;
            prev = 0;
        }
        if (cur >= 0) {
            return true;
        }
    }
    return false;
}



