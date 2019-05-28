
/*

Given a list of 24-hour clock time points in "Hour:Minutes" format, 
find the minimum minutes difference between any two time points in the list.

Example 1:
Input: ["23:59","00:00"]
Output: 1

*/

/*

O(n),O(1)

*/

public int findMinDifference(List<String> timePoints) {
    boolean[] buckets = new boolean[1440];
    for (String timePoint : timePoints) {
        String[] time = timePoint.split(":");
        int h = Integer.valueOf(time[0]);
        int m = Integer.valueOf(time[1]);
        if (buckets[h * 60 + m]) {
            return 0;
        }
        buckets[h * 60 + m] = true;
    }
    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, ans = Integer.MAX_VALUE, prev = -1;
    for (int i = 0; i < buckets.length; ++i) {
        if (buckets[i]) {
            if (prev != -1) {
                ans = Math.min(ans, i - prev);
            }
            prev = i;
            max = Math.max(max, i);
            min = Math.min(min, i); 
        }
    }
    ans = Math.min(ans, min + 1440 - max);
    return ans;
}




