
/*

Given a positive integer n, return the number of all possible attendance records with length n, 
which will be regarded as rewardable. The answer may be very large, return it after mod 109 + 7.
A student attendance record is a string that only contains the following three characters:
'A' : Absent.
'L' : Late.
'P' : Present.
A record is regarded as rewardable if it doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).

Example 1:
Input: n = 2
Output: 8 
Explanation:
There are 8 records with length 2 will be regarded as rewardable:
"PP" , "AP", "PA", "LP", "PL", "AL", "LA", "LL"
Only "AA" won't be regarded as rewardable owing to more than one absent times. 

*/

/*

Solution: PorL[i] means the number of ending with 'P' or 'L', P[i] means the number of ending with 'P'
          P[i]=PorL[i-1] which means add a 'P' after array[i-1]
          PorL[i]=P[i]+P[i-1]+P[i-2] which means we could not have continuous three 'L'
O(n),O(n)          

*/

public int checkRecord(int n) {
    final int M = 1000000000 + 7;
    long[] PorL = new long[n + 1];
    long[] P = new long[n + 1];
    PorL[0] = P[0] = 1;
    PorL[1] = 2;
    P[1] = 1;
    for (int i = 2; i <= n; ++i) {
        P[i] = PorL[i - 1];
        PorL[i] = (P[i] + P[i - 1] + P[i - 2]) % M;
    }
    long ans = PorL[n];
    for (int i = 0; i < n; ++i) {
        long cnt = (PorL[i] * PorL[n - i - 1]) % M;
        ans = (ans + cnt) % M;
    }
    return (int)ans;
}





