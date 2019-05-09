
/*

You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.
Given n, find the total number of full staircase rows that can be formed.
n is a non-negative integer and fits within the range of a 32-bit signed integer.

Example 1:
n = 5
The coins can form the following rows:
¤
¤ ¤
¤ ¤
Because the 3rd row is incomplete, we return 2.

Example 2:
n = 8
The coins can form the following rows:
¤
¤ ¤
¤ ¤ ¤
¤ ¤
Because the 4th row is incomplete, we return 3.

*/

/*

Solution 1: O(n),O(1)

*/

public int arrangeCoins(int n) {
    int ans = 0;
    while (n > 0) {
        ans++;
        n -= ans;
    }
    return n == 0 ? ans : ans - 1;
}


/*

Solution 2: binary search
O(logn),O(1)

*/

public int arrangeCoins(int n) {
    long l = 1, r = n;
    while (l <= r) {
        long mid = l + (r - l) / 2;
        if ((mid + 1) * mid / 2 <= (long)n) l = mid + 1;
        else r = mid - 1;
    }
    return (int)l - 1;
}


/*

Solution 3: sum=(1+level)*level/2, level=(-1+sqrt(1+8*sum))/2
O(1),O(1)

*/

public int arrangeCoins(int n) {
    return (int)((-1 + Math.sqrt(1 + 8 * (long)n)) / 2);
}




