
/*

We are given hours, a list of the number of hours worked per day for a given employee.
A day is considered to be a tiring day if and only if the number of hours worked is (strictly) greater than 8.
A well-performing interval is an interval of days for which 
the number of tiring days is strictly larger than the number of non-tiring days.
Return the length of the longest well-performing interval.

Example 1:
Input: hours = [9,9,6,0,6,6,9]
Output: 3
Explanation: The longest well-performing interval is [9,9,6].

*/

/*

Solution: keep accumulating the count the hour>8 as 1 otherwise as -1
          for cnt>0 which means hours[0...i] is valid
          otherwise, find the index that counts hours[0...j] at most cnt-1 so that hours[j+1...i] is cnt-(cnt-1)=1 which is valid
O(n),O(n)

*/

public int longestWPI(int[] hours) {
    int ans = 0, cnt = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < hours.length; ++i) {
        cnt += hours[i] > 8 ? 1 : -1;
        if (cnt > 0) {
            ans = i + 1;
        } else {
            if (map.containsKey(cnt - 1)) {
                ans = Math.max(ans, i - map.get(cnt - 1));
            }
            map.putIfAbsent(cnt, i);
        }
    }
    return ans;
}



