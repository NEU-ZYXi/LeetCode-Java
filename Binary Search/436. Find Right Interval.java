
/*

Given a set of intervals, for each of the interval i, check if there exists an interval j 
whose start point is bigger than or equal to the end point of the interval i, which can be called that j is on the "right" of i.
For any interval i, you need to store the minimum interval j's index, 
which means that the interval j has the minimum start point to build the "right" relationship for interval i. 
If the interval j doesn't exist, store -1 for the interval i. 
Finally, you need output the stored value of each interval as an array.

Note:
You may assume the interval's end point is always bigger than its start point.
You may assume none of these intervals have the same start point.
 
Example 1:
Input: [ [1,2] ]
Output: [-1]
Explanation: There is only one interval in the collection, so it outputs -1.
 
Example 2:
Input: [ [3,4], [2,3], [1,2] ]
Output: [-1, 0, 1]
Explanation: There is no satisfied "right" interval for [3,4].
For [2,3], the interval [3,4] has minimum-"right" start point;
For [1,2], the interval [2,3] has minimum-"right" start point.
 
Example 3:
Input: [ [1,4], [2,3], [3,4] ]
Output: [-1, 2, -1]
Explanation: There is no satisfied "right" interval for [1,4] and [3,4].
For [2,3], the interval [3,4] has minimum-"right" start point.

*/

/*

Solution 1: use binary search to find the first interval that has a larger start than the current end
O(nlogn),O(n)

*/

public int[] findRightInterval(int[][] intervals) {
    int n = intervals.length;
    int[] ans = new int[n];
    List<Integer> starts = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < n; ++i) {
        starts.add(intervals[i][0]);
        map.put(intervals[i][0], i);
    }
    Collections.sort(starts);
    for (int i = 0; i < n; ++i) {
        int end = intervals[i][1];
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (starts.get(mid) < end) l = mid + 1;
            else r = mid;
        }
        int start = starts.get(l);
        if (start < end) ans[i] = -1;
        else ans[i] = map.get(start);
    }
    return ans;
}


/*

Solution 2: use treemap to store all starts, for each end, find the ceiling start
O(nlogn),O(n)

*/

public int[] findRightInterval(int[][] intervals) {
    int n = intervals.length;
    int[] ans = new int[n];
    TreeMap<Integer, Integer> map = new TreeMap<>();
    for (int i = 0; i < n; ++i) map.put(intervals[i][0], i);
    for (int i = 0; i < n; ++i) {
        Map.Entry<Integer, Integer> entry = map.ceilingEntry(intervals[i][1]);
        if (entry == null) ans[i] = -1;
        else ans[i] = entry.getValue();
    }
    return ans;
}




