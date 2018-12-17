
/*

The set [1,2,3,...,n] contains a total of n! unique permutations.
By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note:
Given n will be between 1 and 9 inclusive.
Given k will be between 1 and n! inclusive.

Example 1:
Input: n = 3, k = 3
Output: "213"

Example 2:
Input: n = 4, k = 9
Output: "2314"

*/

/*

Solution: number of choices for each digit is n,n-1,n-2,...,1
          for the first digit, since for each choice we have (n-1)! choices next, so get the index=(k-1)/(n-1)!
          the same process for all the next digits
O(n*n),O(n)          

*/

public String getPermutation(int n, int k) {
    StringBuilder ans = new StringBuilder();
    int factorial = 1;
    List<Integer> digits = new ArrayList<>();
    for (int i = 1; i <= n; ++i) {
        digits.add(i);
        factorial *= i;
    }
    for (int i = n; i > 0; --i) {
        factorial /= i;
        int idx = (k - 1) / factorial;
        ans.append(digits.remove(idx));
        k -= factorial * idx;
    }
    return ans.toString();
}




