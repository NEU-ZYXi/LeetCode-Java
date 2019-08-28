
/*

Given two integers n and k, you need to construct a list which contains n different positive integers 
ranging from 1 to n and obeys the following requirement: 
Suppose this list is [a1, a2, a3, ... , an], then the list [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] 
has exactly k distinct integers.
If there are multiple answers, print any of them.

Example 1:
Input: n = 3, k = 1
Output: [1, 2, 3]
Explanation: The [1, 2, 3] has three different positive integers ranging from 1 to 3, 
and the [1, 1] has exactly 1 distinct integer: 1.

Example 2:
Input: n = 3, k = 2
Output: [1, 3, 2]
Explanation: The [1, 3, 2] has three different positive integers ranging from 1 to 3,
and the [2, 1] has exactly 2 distinct integers: 1 and 2.

*/

/*

Solution: use 1,n,2,n-1,... to form k distinct distances, then append other numbers after them
O(n),O(n)

*/

public int[] constructArray(int n, int k) {
    int[] ans = new int[n];
    int i = 0, min = 1, max = n;
    while (i < k) {
        ans[i++] = min++;
        if (i < k) {
            ans[i++] = max--;
        }
    }
    if (k % 2 == 0) {
        while (i < n) {
            ans[i++] = max--;
        }
    } else {
        while (i < n) {
            ans[i++] = min++;
        }
    }
    return ans;
}




