
/*

We are given a list schedule of employees, which represents the working time for each employee.
Each employee has a list of non-overlapping Intervals, and these intervals are in sorted order.
Return the list of finite intervals representing common, positive-length free time for all employees, also in sorted order.

Example 1:
Input: schedule = [[[1,2],[5,6]],[[1,3]],[[4,10]]]
Output: [[3,4]]
Explanation:
There are a total of three employees, and all common
free time intervals would be [-inf, 1], [3, 4], [10, inf].
We discard any intervals that contain inf as they aren't finite.

Example 2:
Input: schedule = [[[1,3],[6,7]],[[2,4]],[[2,5],[9,12]]]
Output: [[5,6],[7,9]]

*/

/*

Solution 1: O(nlogn),O(n)

*/

// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start,int _end) {
        start = _start;
        end = _end;
    }
};
*/
public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
    List<Interval> ans = new ArrayList<>();
    List<Interval> intervals = new ArrayList<>();
    for (List<Interval> interval : schedule) {
        intervals.addAll(interval);
    }
    Collections.sort(intervals, new Comparator<Interval>() {
        @Override
        public int compare(Interval a, Interval b) {
            return a.start - b.start;
        }
    });
    int end = intervals.get(0).end;
    for (Interval interval : intervals) {
        if (interval.start > end) {
            ans.add(new Interval(end, interval.start));
        }
        end = Math.max(end, interval.end);
    }
    return ans;
}


/*

Solution 2: O(nlogn),O(n)

*/

public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
    List<Interval> ans = new ArrayList<>();
    PriorityQueue<Interval> pq = new PriorityQueue<>(new Comparator<Interval>() {
        @Override
        public int compare(Interval a, Interval b) {
            return a.start - b.start;
        }
    });
    for (List<Interval> interval : schedule) {
        pq.addAll(interval);
    }
    int end = pq.peek().end;
    while (!pq.isEmpty()) {
        Interval cur = pq.poll();
        if (cur.start > end) {
            ans.add(new Interval(end, cur.start));
        }
        end = Math.max(end, cur.end);
    }
    return ans;
}




