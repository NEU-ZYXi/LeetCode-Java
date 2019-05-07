
/*

Given a collection of intervals, find the minimum number of intervals you need to remove 
to make the rest of the intervals non-overlapping.
Note:
You may assume the interval's end point is always bigger than its start point.
Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.
 
Example 1:
Input: [ [1,2], [2,3], [3,4], [1,3] ]
Output: 1
Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
 
Example 2:
Input: [ [1,2], [1,2], [1,2] ]
Output: 2
Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
 
Example 3:
Input: [ [1,2], [2,3] ]
Output: 0
Explanation: You don't need to remove any of the intervals since they're already non-overlapping.

*/

/*

Solution: use end to sort in increasing order, greedily select every non-overlapping intervals and the remain should be removed
O(nlogn),O(1)

*/

public int eraseOverlapIntervals(int[][] intervals) {
    int n = intervals.length;
    if (n == 0) return 0;
    Arrays.sort(intervals, new Comparator<int[]>() {
        @Override
        public int compare(int[] a, int[] b) {
            return a[1] == b[1] ? a[0] - b[0] : a[1] - b[1];
        }
    });
    int end = intervals[0][1], cnt = 1;
    for (int i = 1; i < n; ++i) {
        if (intervals[i][0] >= end) {
            end = intervals[i][1];
            cnt++;
        }
    }
    return n - cnt;
}




