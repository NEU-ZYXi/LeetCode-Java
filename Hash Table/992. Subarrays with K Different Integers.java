
/*

Given an array A of positive integers, call a (contiguous, not necessarily distinct) subarray of A good 
if the number of different integers in that subarray is exactly K.
(For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.)
Return the number of good subarrays of A.

Example 1:
Input: A = [1,2,1,2,3], K = 2
Output: 7
Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].

Example 2:
Input: A = [1,2,1,3,4], K = 3
Output: 3
Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].

*/

/*

Solution 1: maintain a sliding window, expand the right bound and count the number of different numbers 
            when we have more than one left number, keep removing them and accumulate as the prefix of subarrays
            if cnt>K which means we need to shrink left bound, remove left number which should be only 1 in current window
O(n),O(n)            

*/

public int subarraysWithKDistinct(int[] A, int K) {
    Map<Integer, Integer> map = new HashMap<>();
    int ans = 0, cnt = 0, acc = 0, n = A.length;
    for (int i = 0, j = 0; j < n; ++j) {
        if (!map.containsKey(A[j])) {
            cnt++;
        }
        map.put(A[j], map.getOrDefault(A[j], 0) + 1);
        if (cnt > K) {
            map.remove(A[i]);
            cnt--;
            acc = 0;
            i++;
        }
        while (map.get(A[i]) > 1) {
            map.put(A[i], map.get(A[i]) - 1);
            acc++;
            i++;
        }
        if (cnt == K) {
            ans += acc + 1;
        }
    }
    return ans;
}


/*

Solution 2: use sliding window to calculate the number of subarrays with at most K different integers
            atMost(K)-atMost(K-1)=subarrays with exact K different integers
O(n),O(n)            

*/

public int subarraysWithKDistinct(int[] A, int K) {
    return subarraysWithAtMostKDistinct(A, K) - subarraysWithAtMostKDistinct(A, K - 1);
}

private int subarraysWithAtMostKDistinct(int[] A, int K) {
    int ans = 0, cnt = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0, j = 0; j < A.length; ++j) {
        if (!map.containsKey(A[j])) {
            cnt++;
        }
        map.put(A[j], map.getOrDefault(A[j], 0) + 1);
        while (cnt > K) {
            map.put(A[i], map.get(A[i]) - 1);
            if (map.get(A[i]) == 0) {
                cnt--;
                map.remove(A[i]);
            }
            i++;
        }
        ans += j - i + 1;
    }
    return ans;
}




