
/*

Given an array of 4 digits, return the largest 24 hour time that can be made.
The smallest 24 hour time is 00:00, and the largest is 23:59.  
Starting from 00:00, a time is larger if more time has elapsed since midnight.
Return the answer as a string of length 5.  
If no valid time can be made, return an empty string.

Example 1:
Input: [1,2,3,4]
Output: "23:41"

Example 2:
Input: [5,5,5,5]
Output: ""

*/

/*

O(1),O(1)

*/

public String largestTimeFromDigits(int[] A) {
    String ans = "";
    for (int i = 0; i < 4; ++i) {
        for (int j = 0; j < 4; ++j) {
            for (int k = 0; k < 4; ++k) {
                if (i == j || i == k || j == k) {
                    continue;
                }
                String hour = A[i] + "" + A[j];
                String minute = A[k] + "" + A[6 - i - j - k];
                String time = hour + ":" + minute;
                if (Integer.valueOf(hour) < 24 && Integer.valueOf(minute) < 60 && ans.compareTo(time) < 0) {
                    ans = time;
                }
            }
        }
    }
    return ans;
}




