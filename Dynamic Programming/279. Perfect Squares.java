
/*

Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Example 1:
Input: n = 12
Output: 3 
Explanation: 12 = 4 + 4 + 4.

Example 2:
Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.

*/

/*

Solution 1: dp[i] means minimum number of square for i
            dp[i]=min(dp[i-j*j]+1) where j*j is a square number
O(n*sqrt(n)),O(n)            

*/

public int numSquares(int n) {
    int[] dp = new int[n + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;
    for (int i = 1; i <= n; ++i) {
        for (int j = 1; j * j <= i; ++j) dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
    }
    return dp[n];
}


/*

Solution 2: 由拉格朗日四平方和定理(Lagrange's four-square theorem)可知任意数都最多是4个数的平方和，因此结果只有4种情况
            由欧拉恒等式(a²+b²+c²+d²)(e²+f²+g²+h²)=(ae+bf+cg+dh)²+(af-be+ch-dg)²+(ag-bh-ce+df)²+(-ah-bg+cf+de)²可证
            4平方和的唯一情况是该数为4^i*(8*j+7)
O(sqrt(n)),O(1)            

*/

public int numSquares(int n) {
    if (isSquare(n)) return 1;
    int sqrt = (int)Math.sqrt(n);
    for (int i = 1; i <= sqrt; ++i) {
        if (isSquare(n - i * i)) return 2;
    }
    while (n % 4 == 0) n /= 4;
    if ((n - 7) % 8 == 0) return 4;
    return 3;
}

private boolean isSquare(int n) {
    int sqrt = (int)Math.sqrt(n);
    return sqrt * sqrt == n;
}




