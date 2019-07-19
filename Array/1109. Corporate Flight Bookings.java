
/*

There are n flights, and they are labeled from 1 to n.
We have a list of flight bookings.  
The i-th booking bookings[i] = [i, j, k] means that we booked k seats from flights labeled i to j inclusive.
Return an array answer of length n, representing the number of seats booked on each flight in order of their label.

Example 1:
Input: bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
Output: [10,55,45,25,25]

*/

/*

O(n),O(n)

*/

public int[] corpFlightBookings(int[][] bookings, int n) {
    int[] ans = new int[n];
    for (int[] booking : bookings) {
        int l = booking[0], r = booking[1], cnt = booking[2];
        ans[l - 1] += cnt;
        if (r < n) {
            ans[r] -= cnt;
        }
    }
    for (int i = 1; i < n; ++i) {
        ans[i] += ans[i - 1];
    }
    return ans;
}



