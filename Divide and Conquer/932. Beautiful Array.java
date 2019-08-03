
/*

For some fixed N, an array A is beautiful if it is a permutation of the integers 1, 2, ..., N, such that:
For every i < j, there is no k with i < k < j such that A[k] * 2 = A[i] + A[j].
Given N, return any beautiful array A.  (It is guaranteed that one exists.)

Example 1:
Input: 4
Output: [2,1,4,3]

Example 2:
Input: 5
Output: [3,1,2,5,4]

*/

/*

Solution: for odd part and even part, A[k]*2 must not be equal to odd+even
          then we need to build beautiful odd part and beautiful even part
          for current beautiful array, use A[i]*2-1 and A[i]*2 as next array since addition and multiplication won't affect beautiful
O(n),O(n)          

*/

public int[] beautifulArray(int N) {
    List<Integer> ans = new ArrayList<>();
    ans.add(1);
    while (ans.size() < N) {
        List<Integer> next = new ArrayList<>();
        for (int num : ans) {
            if (num * 2 - 1 <= N) {
                next.add(num * 2 - 1);
            }
        }
        for (int num : ans) {
            if (num * 2 <= N) {
                next.add(num * 2);
            }
        }
        ans = next;
    }
    return ans.stream().mapToInt(i -> i).toArray();
}




