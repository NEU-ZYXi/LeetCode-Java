
/*

Given a positive integer a, find the smallest positive integer b whose multiplication of each digit equals to a.
If there is no answer or the answer is not fit in 32-bit signed integer, then return 0.

Example 1
Input:
48 
Output:
68

Example 2
Input:
15
Output:
35

*/

/*

O(logn),O(1)

*/

public int smallestFactorization(int a) {
    if (a < 10) {
        return a;
    }
    long ans = 0;
    for (long i = 9, cur = 1; i > 1; --i) {
        while (a % i == 0) {
            ans += cur * i;
            if (ans > Integer.MAX_VALUE) {
                return 0;
            }
            a /= i;
            cur *= 10;
        }
    }
    return a == 1 ? (int)ans : 0;
}




