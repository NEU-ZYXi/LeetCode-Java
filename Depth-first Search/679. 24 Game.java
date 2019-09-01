
/*

You have 4 cards each containing a number from 1 to 9. 
You need to judge whether they could operated through *, /, +, -, (, ) to get the value of 24.

Example 1:
Input: [4, 1, 8, 7]
Output: True
Explanation: (8-4) * (7-1) = 24

Example 2:
Input: [1, 2, 1, 2]
Output: False

*/

/*

O(6^(n^2)),O(n^2)

*/

public boolean judgePoint24(int[] nums) {
    List<Double> ans = new ArrayList<>();
    for (int num : nums) {
        ans.add((double)num);
    }
    return dfs(ans);
}

private boolean dfs(List<Double> ans) {
    if (ans.size() == 1) {
        if (Math.abs(ans.get(0) - 24.0) < 1e-6) {
            return true;
        }
        return false;
    }
    for (int i = 0; i < ans.size(); ++i) {
        for (int j = 0; j < i; ++j) {
            double a = ans.get(i), b = ans.get(j);
            double[] ops = new double[] {a + b, a - b, b - a, a * b, a / b, b / a};
            ans.remove(i);
            ans.remove(j);
            for (double op : ops) {
                ans.add(op);
                if (dfs(ans)) {
                    return true;
                }
                ans.remove(ans.size() - 1);
            }
            ans.add(j, b);
            ans.add(i, a);
        }
    }
    return false;
}




