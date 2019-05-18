
/*

By now, you are given a secret signature consisting of character 'D' and 'I'. 
'D' represents a decreasing relationship between two numbers, 'I' represents an increasing relationship between two numbers. 
And our secret signature was constructed by a special integer array, 
which contains uniquely all the different number from 1 to n (n is the length of the secret signature plus 1). 
For example, the secret signature "DI" can be constructed by array [2,1,3] or [3,1,2], 
but won't be constructed by array [3,2,4] or [2,1,3,4], 
which are both illegal constructing special string that can't represent the "DI" secret signature.
Find the lexicographically smallest permutation of [1, 2, ... n] could refer to the given secret signature in the input.

Example 1:
Input: "I"
Output: [1,2]
Explanation: [1,2] is the only legal initial spectial string can construct secret signature "I", 
where the number 1 and 2 construct an increasing relationship.

Example 2:
Input: "DI"
Output: [2,1,3]
Explanation: Both [2,1,3] and [3,1,2] can construct the secret signature "DI", 
but since we want to find the one with the smallest lexicographical permutation, you need to output [2,1,3]

*/

/*

Solution: start from the sorted array so we don't need to check 'I'
          get all consecutive 'D' and reverse the subarray, greedily satify the lexicographically requirement
O(n),O(n)

*/

public int[] findPermutation(String s) {
    int n = s.length();
    int[] ans = new int[n + 1];
    for (int i = 0; i <= n; ++i) {
        ans[i] = i + 1;
    }
    for (int i = 0; i < n; ++i) {
        if (s.charAt(i) == 'D') {
            int j = i;
            while (i < n && s.charAt(i) == 'D') {
                i++;
            }
            reverse(ans, j, i);
        }
    }
    return ans;
}

private void reverse(int[] ans, int l, int r) {
    while (l < r) {
        int tmp = ans[l];
        ans[l] = ans[r];
        ans[r] = tmp;
        l++;
        r--;
    }
}





