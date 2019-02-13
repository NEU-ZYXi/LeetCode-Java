
/*

Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

Example:
Input: 38
Output: 2 
Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2. 
             Since 2 has only one digit, return it.

*/

/*

Solution 1: iterative way
O(n),O(1)

*/

public int addDigits(int num) {
    int ans = 0;
    while (true) {
        while (num != 0) {
            ans += num % 10;
            num /= 10;
        }
        if (ans < 10) return ans;
        else {
            num = ans;
            ans = 0;
        }
    }
}


/*

Solution 2: let a[0],a[1],...,a[n] be the digits, then num=a[0]*10^0+a[1]*10^1+...+a[n]*10^n
            num=a[0]+a[1]+...+a[n]+(a[1]*9+a[2]*99+...+a[n]*9.(n-1).9)=N+M, where M%9=0
            so num%9=(N+M)%9, num%9=N
O(1),O(1)            

*/

public int addDigits(int num) {
    if (num == 0) return 0;
    if (num % 9 == 0) return 9;
    return num % 9;
}


