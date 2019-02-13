
/*

Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), 
find the minimum number of conference rooms required.

Example 1:
Input: [[0, 30],[5, 10],[15, 20]]
Output: 2

Example 2:
Input: [[7,10],[2,4]]
Output: 1

*/

/*

Solution 1: sort the array in ascending order of start, use priority queue to store the intervals in ascending order of end
            in the priority queue, if the last interval has intersection with a new interval, offer the new one
            otherwise, extend the end to cover two intervals
O(nlogn),O(n)            

*/

public int minMeetingRooms(Interval[] intervals) {
    int n = intervals.length;
    if (n == 0) return 0;
    Arrays.sort(intervals, (a, b) -> a.start - b.start);
    PriorityQueue<Interval> pq = new PriorityQueue<Interval>((a, b) -> a.end - b.end);
    pq.offer(intervals[0]);
    for (int i = 1; i < n; ++i) {
        Interval cur = pq.poll();
        if (cur.end <= intervals[i].start) cur.end = intervals[i].end;
        else pq.offer(intervals[i]);
        pq.offer(cur);
    }
    return pq.size();
}


/*

Solution 2: 差分(difference)方法，将一个interval用左右两个端点代替，左端点为+1，右端点为-1，用TreeMap统计
O(nlogn),O(n)

*/

public int minMeetingRooms(Interval[] intervals) {
    int ans = 0, cnt = 0;
    TreeMap<Integer, Integer> map = new TreeMap<>();
    for (Interval interval : intervals) {
        map.put(interval.start, map.getOrDefault(interval.start, 0) + 1);
        map.put(interval.end, map.getOrDefault(interval.end, 0) - 1);
    }
    for (int timepoint : map.keySet()) {
        cnt += map.get(timepoint);
        ans = Math.max(ans, cnt);
    }
    return ans;
}




