
/*

Given integers n and k, find the lexicographically k-th smallest integer in the range from 1 to n.
Note: 1 ≤ k ≤ n ≤ 109.

Example:
Input:
n: 13   k: 2
Output:
10
Explanation:
The lexicographical order is [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9], so the second smallest number is 10.

*/

/*

Solution: for i and i+1, count the numbers between them, if cnt<k then kth number is after i+1, otherwise check i*10
O(1),O(1)

*/

public int findKthNumber(int n, int k) {
    int ans = 1;
    while (k > 1) {
        int cnt = count(ans, ans + 1, n);
        if (cnt < k) {
            ans++;
            k -= cnt;
        } else {
            ans *= 10;
            k--;
        }
    }
    return ans;
}

private int count(long l, long r, int n) {
    int cnt = 0;
    while (l <= n) {
        cnt += Math.min(r, n + 1) - l;
        l *= 10;
        r *= 10;
    }
    return cnt;
}





