
/*

Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:
Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]

Example 2:
Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

*/

/*

O(n),O(1)

*/

public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    List<Interval> ans = new ArrayList<>();
    for (int i = 0; i < intervals.size(); ++i) {
        if (newInterval == null || intervals.get(i).end < newInterval.start) 
            ans.add(intervals.get(i));
        else if (intervals.get(i).start > newInterval.end) {
            ans.add(newInterval);
            ans.add(intervals.get(i));
            newInterval = null;
        } else {
            newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
            newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
        }
    }
    if (newInterval != null) ans.add(newInterval);
    return ans;
}



