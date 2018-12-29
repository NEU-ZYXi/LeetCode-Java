
/*

Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:
Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

*/

/*

O(n^2),O(n)

*/

public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> ans = new ArrayList<>();
    for (int i = 0; i < numRows; ++i) {
        List<Integer> tmp = new ArrayList<>();
        for (int j = 0; j <= i; ++j) {
            if (j == 0 || j == i) tmp.add(1);
            else tmp.add(ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
        }
        ans.add(tmp);
    }
    return ans;
}




