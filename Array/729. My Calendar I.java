
/*

Implement a MyCalendar class to store your events.
A new event can be added if adding the event will not cause a double booking.
Your class will have the method, book(int start, int end). 
Formally, this represents a booking on the half open interval [start, end), 
the range of real numbers x such that start <= x < end.
A double booking happens when two events have some non-empty intersection 
(ie., there is some time that is common to both events.)
For each call to the method MyCalendar.book, 
return true if the event can be added to the calendar successfully without causing a double booking. 
Otherwise, return false and do not add the event to the calendar.
Your class will be called like this: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)

Example 1:
MyCalendar();
MyCalendar.book(10, 20); // returns true
MyCalendar.book(15, 25); // returns false
MyCalendar.book(20, 30); // returns true
Explanation: 
The first event can be booked.  The second can't because time 15 is already booked by another event.
The third event can be booked, as the first event takes every time less than 20, but not including 20.

*/

/*

Solution 1: O(n),O(n)

*/

class MyCalendar {
    private List<int[]> calendar;

    public MyCalendar() {
        this.calendar = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for (int[] interval : calendar) {
            if (interval[1] > start && interval[0] < end) {
                return false;
            }
        }
        calendar.add(new int[] {start, end});
        return true;
    }
}


/*

Solution 2: O(logn),O(n)

*/

class MyCalendar {
    private TreeMap<Integer, Integer> map;

    public MyCalendar() {
        this.map = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Integer prev = map.floorKey(start);
        Integer next = map.ceilingKey(start);
        if ((prev == null || map.get(prev) <= start) && (next == null || next >= end)) {
            map.put(start, end);
            return true;
        }
        return false;
    }
}


/*

Solution 3: O(logn),O(n)

*/

class MyCalendar {
    private List<int[]> calendar;

    public MyCalendar() {
        this.calendar = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        int next = binarySearch(start);
        if (next == calendar.size() || calendar.get(next)[0] >= end) {
            calendar.add(next, new int[] {start, end});
            return true;
        }
        return false;
    }
    
    private int binarySearch(int start) {
        int l = 0, r = calendar.size();
        while (l < r) {
            int mid = (l + r) / 2;
            int[] cur = calendar.get(mid);
            if (cur[0] > start) {
                r = mid;
            } else if (cur[1] <= start) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return l;
    }
}





