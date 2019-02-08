
/*

Given a string of numbers and operators, 
return all possible results from computing all the different possible ways to group numbers and operators. 
The valid operators are +, - and *.

Example 1:
Input: "2-1-1"
Output: [0, 2]
Explanation: 
((2-1)-1) = 0 
(2-(1-1)) = 2

Example 2:
Input: "2*3-4*5"
Output: [-34, -14, -10, -10, 10]
Explanation: 
(2*(3-(4*5))) = -34 
((2*3)-(4*5)) = -14 
((2*(3-4))*5) = -10 
(2*((3-4)*5)) = -10 
(((2*3)-4)*5) = 10

*/

/*

Solution: when we have a '+' or '-' or '*', recursively solve left and right part
          then based on s[i], combine each possible values of two parts to get one of the final results
          use memoization to store the duplicate string
O(n!),O(n), where the number of ways to add parentheses is Catalan number that is Cn=(2n)!/((n+1)!n!)          

*/

public List<Integer> diffWaysToCompute(String input) {
    Map<String, List<Integer>> memo = new HashMap<>();
    return solve(input, memo);
}

private List<Integer> solve(String s, Map<String, List<Integer>> memo) {
    if (memo.containsKey(s)) return memo.get(s);
    List<Integer> ans = new ArrayList<>();
    for (int i = 0; i < s.length(); ++i) {
        char c = s.charAt(i);
        if (c == '+' || c == '-' || c == '*') {
            List<Integer> left = solve(s.substring(0, i), memo), right = solve(s.substring(i + 1), memo);
            for (int l : left) {
                for (int r : right) {
                    if (c == '+') ans.add(l + r);
                    else if (c == '-') ans.add(l - r);
                    else ans.add(l * r);
                }
            }
        }
    }
    if (ans.size() == 0) ans.add(Integer.valueOf(s));
    memo.put(s, ans);
    return ans;
}




