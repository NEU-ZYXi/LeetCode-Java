
/*

Write a program to find the n-th ugly number.
Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 

Example:
Input: n = 10
Output: 12
Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

*/

/*

Solution: num2,num3,num5 means the index of next element can be multiplied with 2,3,5
          ans[i]=min(ans[num2]*2,ans[num3]*3,ans[num5]*5), and move the corresponding index if 2,3,5 is multiplied
O(n),O(n)          

*/

public int nthUglyNumber(int n) {
    int[] ans = new int[n];
    ans[0] = 1;
    int num2 = 0, num3 = 0, num5 = 0;
    for (int i = 1; i < n; ++i) {
        ans[i] = Math.min(ans[num2] * 2, Math.min(ans[num3] * 3, ans[num5] * 5));
        if (ans[i] == ans[num2] * 2) num2++;
        if (ans[i] == ans[num3] * 3) num3++;
        if (ans[i] == ans[num5] * 5) num5++;
    }
    return ans[n - 1];
}




