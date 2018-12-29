
/*

Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
Note that the row index starts from 0.
In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:
Input: 3
Output: [1,3,3,1]

*/

/*

Solution: add 1 to the list in each level, and simulate the pascal's triangle adding process
          1
          11
          111 -> 121
          1211 -> 1331
          13311 -> 14641
O(n^2),O(n)          

*/

public List<Integer> getRow(int rowIndex) {
    List<Integer> ans = new ArrayList<>();
    for (int i = 0; i <= rowIndex; ++i) {
        ans.add(1);
        for (int j = i - 1; j >= 1; --j) {
            ans.set(j, ans.get(j - 1) + ans.get(j));
        }
    }
    return ans;
}



