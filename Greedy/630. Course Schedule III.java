
/*

There are n different online courses numbered from 1 to n. 
Each course has some duration(course length) t and closed on dth day. 
A course should be taken continuously for t days and must be finished before or on the dth day. 
You will start at the 1st day.
Given n online courses represented by pairs (t,d), your task is to find the maximal number of courses that can be taken.

Example:
Input: [[100, 200], [200, 1300], [1000, 1250], [2000, 3200]]
Output: 3
Explanation: 
There're totally 4 courses, but you can take 3 courses at most:
First, take the 1st course, it costs 100 days so you will finish it on the 100th day, 
and ready to take the next course on the 101st day.
Second, take the 3rd course, it costs 1000 days so you will finish it on the 1100th day, 
and ready to take the next course on the 1101st day. 
Third, take the 2nd course, it costs 200 days so you will finish it on the 1300th day. 
The 4th course cannot be taken now, since you will finish it on the 3300th day, which exceeds the closed date.

*/

/*

Solution: sort courses by their close time, use a priority queue to store durations in descending order
          for each course, greedily take it, if we find there exists a course which has less duration, choose it and update duration
O(nlogn),O(n)          

*/

public int scheduleCourse(int[][] courses) {
    if (courses.length == 0) {
        return 0;
    }
    Arrays.sort(courses, new Comparator<int[]>() {
        @Override
        public int compare(int[] a, int[] b) {
            return a[1] - b[1];
        }
    });
    PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer a, Integer b) {
            return b - a;
        }
    });
    int duration = 0;
    for (int i = 0; i < courses.length; ++i) {
        if (duration + courses[i][0] <= courses[i][1]) {
            duration += courses[i][0];
            pq.offer(courses[i][0]);
        } else {
            if (!pq.isEmpty() && pq.peek() > courses[i][0]) {
                duration -= pq.poll() - courses[i][0];
                pq.offer(courses[i][0]);
            }
        }
    }
    return pq.size();
}




