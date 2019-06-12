
/*

Given an array A of integers, return the number of (contiguous, non-empty) subarrays that have a sum divisible by K.

Example 1:
Input: A = [4,5,0,-2,-3,1], K = 5
Output: 7
Explanation: There are 7 subarrays with a sum divisible by K = 5:
[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]

*/

/*

O(n),O(n)

*/

public int subarraysDivByK(int[] A, int K) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);
    int ans = 0, sum = 0;
    for (int a : A) {
        sum = (sum + a) % K;
        if (sum < 0) {
            sum += K;
        }
        ans += map.getOrDefault(sum, 0);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
    }
    return ans;
}



