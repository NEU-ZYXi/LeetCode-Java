
/*

Your task is to calculate ab mod 1337 where a is a positive integer and b is an extremely large positive integer 
given in the form of an array.

Example 1:
Input: a = 2, b = [3]
Output: 8

Example 2:
Input: a = 2, b = [1,0]
Output: 1024

*/

/*

Solution: a^(b[0...n])=a^(b[0]*10^n)*a^(b[1]*10^(n-1))*...*a^(b[n-2]*10)*a^(b[n-1]*1)
O(n),O(1)

*/

private final int MOD = 1337;
    
public int superPow(int a, int[] b) {
    if (b.length == 0) return 1;
    return superPow(a, b, b.length - 1);
}

private int superPow(int a, int[] b, int idx) {
    if (idx == 0) return pow(a, b[0]);
    int cur = b[idx];
    return pow(superPow(a, b, idx - 1), 10) * pow(a, cur) % MOD;
}

private int pow(int a, int b) {
    a %= MOD;
    int ans = 1;
    for (int i = 0; i < b; ++i) {
        ans = (ans * a) % MOD;
    }
    return ans;
}




