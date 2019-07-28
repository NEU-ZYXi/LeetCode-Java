
/*

The Tribonacci sequence Tn is defined as follows: 
T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
Given n, return the value of Tn.

Example 1:
Input: n = 4
Output: 4
Explanation:
T_3 = 0 + 1 + 1 = 2
T_4 = 1 + 1 + 2 = 4

Example 2:
Input: n = 25
Output: 1389537

*/

/*

O(n),O(1)

*/

public int tribonacci(int n) {
    if (n < 2) {
        return n;
    }
    int first = 1, second = 1, third = 0;
    while (n > 2) {
        int cur = first + second + third;
        third = second;
        second = first;
        first = cur;
        n--;
    }
    return first;
}



