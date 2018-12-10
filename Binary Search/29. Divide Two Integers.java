
/*

Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
Return the quotient after dividing dividend by divisor.
The integer division should truncate toward zero.

Example 1:
Input: dividend = 10, divisor = 3
Output: 3

Example 2:
Input: dividend = 7, divisor = -3
Output: -2

*/

/*

O(log(dvd)),O(1)

*/

public int divide(int dividend, int divisor) {
    if (dividend == Integer.MIN_VALUE && divisor == -1)
        return Integer.MAX_VALUE;
    int sign = (dividend > 0) ^ (divisor > 0) ? -1 : 1;
    long dvd = Math.abs((long)dividend);
    long dvs = Math.abs((long)divisor);
    int ans = 0;
    while (dvd >= dvs) {
        long tmp = dvs, cnt = 1;
        while (dvd >= (tmp << 1)) {
            tmp <<= 1;
            cnt <<= 1;
        } 
        dvd -= tmp;
        ans += cnt;
    }
    return sign * ans;
}



