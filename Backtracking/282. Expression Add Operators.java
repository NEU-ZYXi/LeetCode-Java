
/*

Given a string that contains only digits 0-9 and a target value, 
return all possibilities to add binary operators (not unary) +, -, or * between the digits so they equal to the target value.

Example 1:
Input: num = "123", target = 6
Output: ["1+2+3", "1*2*3"] 

Example 2:
Input: num = "232", target = 8
Output: ["2*3+2", "2+3*2"]

Example 3:
Input: num = "105", target = 5
Output: ["1*0+5","10-5"]

Example 4:
Input: num = "00", target = 0
Output: ["0+0", "0-0", "0*0"]

Example 5:
Input: num = "3456237490", target = 9191
Output: []

*/

/*

O(3^n),O(n)

*/

public List<String> addOperators(String num, int target) {
    List<String> ans = new ArrayList<>();
    if (num.length() == 0) return ans;
    dfs(ans, new StringBuilder(), num, target, 0, 0, 0);
    return ans;
}

private void dfs(List<String> ans, StringBuilder tmp, String num, int target, int idx, long prev, long cur) {
    if (idx == num.length()) {
        if (cur == target) ans.add(tmp.toString());
        return;
    }
    for (int i = idx; i < num.length(); ++i) {
        if (i > idx && num.charAt(idx) == '0') return;
        long number = Long.valueOf(num.substring(idx, i + 1));
        int len = tmp.length();
        if (idx == 0) {
            dfs(ans, tmp.append(number), num, target, i + 1, number, number);
            tmp.setLength(len);
        } else {
            dfs(ans, tmp.append("+").append(number), num, target, i + 1, number, cur + number);
            tmp.setLength(len);
            dfs(ans, tmp.append("-").append(number), num, target, i + 1, -number, cur - number);
            tmp.setLength(len);
            dfs(ans, tmp.append("*").append(number), num, target, i + 1, prev * number, cur - prev + prev * number);
            tmp.setLength(len);
        }
    }
}




