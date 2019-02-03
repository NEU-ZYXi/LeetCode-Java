
/*

Count the number of prime numbers less than a non-negative number, n.

Example:
Input: 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.

*/

/*

O(nlog(logn)),O(n)

*/

public int countPrimes(int n) {
    int ans = 0;
    boolean[] notPrimes = new boolean[n];
    for (int i = 2; i < n; ++i) {
        if (!notPrimes[i]) {
            ans++;
            if (i * i < n) {
                for (int j = 2; i * j < n; ++j) notPrimes[i * j] = true;
            }
        }
    }
    return ans;
}



