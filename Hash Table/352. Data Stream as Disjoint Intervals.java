
/*

Given a data stream input of non-negative integers a1, a2, ..., an, ..., summarize the numbers seen so far 
as a list of disjoint intervals.

For example, suppose the integers from the data stream are 1, 3, 7, 2, 6, ..., then the summary will be:
[1, 1]
[1, 1], [3, 3]
[1, 1], [3, 3], [7, 7]
[1, 3], [7, 7]
[1, 3], [6, 7]

*/

/*

Solution: use treemap to get the left and right interval, compare with the current value to check intersection
O(nlogn),O(n)

*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class SummaryRanges {
    
    private TreeMap<Integer, Interval> map;

    /** Initialize your data structure here. */
    public SummaryRanges() {
        this.map = new TreeMap<>();
    }
    
    public void addNum(int val) {
        if (map.containsKey(val)) return;
        Integer left = map.floorKey(val);
        Integer right = map.ceilingKey(val);
        if (left != null && right != null && map.get(left).end == val - 1 && right == val + 1) {
            map.get(left).end = map.get(right).end;
            map.remove(right);
        } else if (right != null && right == val + 1) {
            map.put(val, new Interval(val, map.get(right).end));
            map.remove(right);
        } else if (left != null && map.get(left).end >= val - 1) map.get(left).end = Math.max(map.get(left).end, val);
        else map.put(val, new Interval(val, val));
    }
    
    public List<Interval> getIntervals() {
        return new ArrayList<>(map.values());
    }
}





