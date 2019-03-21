
/*

You have a number of envelopes with widths and heights given as a pair of integers (w, h). 
One envelope can fit into another iff both the width and height of one envelope is greater than those of the other envelope.
What is the maximum number of envelopes can you Russian doll? (put one inside other)
Note:
Rotation is not allowed.

Example:
Input: [[5,4],[6,4],[6,7],[2,3]]
Output: 3 
Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).

*/

/*

Solution: sort envelopes by their left in increasing order and right in decreasing order
          find the LIS of their right since left is already in order
          for a and b where a[0]=b[0],a[1]>b[1], after updating dp[i] with a[1], we could still update dp[i] with b[1]
O(nlogn),O(n)          

*/

public int maxEnvelopes(int[][] envelopes) {
    int n = envelopes.length;
    if (n < 2) return n;
    Arrays.sort(envelopes, new Comparator<int[]>() {
        @Override
        public int compare(int[] a, int[] b) {
            return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];     
        }
    });
    int[] dp = new int[n];
    int ans = 0;
    for (int[] envelope : envelopes) {
        int l = 0, r = ans;
        while (l < r) {
            int mid = (l + r) / 2;
            if (dp[mid] < envelope[1]) l = mid + 1;
            else r = mid;
        }
        dp[l] = envelope[1];
        if (l == ans) ans++;
    }
    return ans;
}




