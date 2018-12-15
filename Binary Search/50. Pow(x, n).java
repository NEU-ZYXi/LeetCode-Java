
/*

Implement pow(x, n), which calculates x raised to the power n (xn).

Example 1:
Input: 2.00000, 10
Output: 1024.00000

Example 2:
Input: 2.10000, 3
Output: 9.26100

Example 3:
Input: 2.00000, -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25

*/

/*

Solution 1.
recursive way, x^n=(x*x)^(n/2)=...=x*(x*x)^(n/2) if n is odd number
O(logn),O(1)

*/

public double myPow(double x, int n) {
    if (n == 0) return 1;
    if (x == 1) return 1;
    if (x == -1) return n % 2 == 0 ? 1 : -1;
    if (n == Integer.MIN_VALUE) return 0;
    if (n < 0) {
        n = -n;
        x = 1 / x;
    }
    return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
}


/*

Solution 2.
iterative way, the same above
O(logn),O(1)

*/

public double myPow(double x, int n) {
    if (n == 0) return 1;
    if (x == 1) return 1;
    if (x == -1) return n % 2 == 0 ? 1 : -1;
    if (n == Integer.MIN_VALUE) return 0;
    if (n < 0) {
        n = -n;
        x = 1 / x;
    }
    double ans = 1;
    while (n > 0) {
        if (n % 2 == 1) ans *= x;
        x *= x;
        n /= 2;
    }
    return ans;
}




