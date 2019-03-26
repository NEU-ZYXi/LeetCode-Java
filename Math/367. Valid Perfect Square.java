
/*

Given a positive integer num, write a function which returns True if num is a perfect square else False.
Note: Do not use any built-in library function such as sqrt.

Example 1:
Input: 16
Output: true

Example 2:
Input: 14
Output: false

*/

/*

O(logn),O(1)

*/

public boolean isPerfectSquare(int num) {
    if (num <= 0) return false;
    int l = 1, r = num;
    while (l <= r) {
        int mid = (l + r) / 2;
        if (mid == num / mid) return num % mid == 0;
        else if (mid < num / mid) l = mid + 1;
        else r = mid - 1;
    }
    return false;
}



