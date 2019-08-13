
/*

Solve a given equation and return the value of x in the form of string "x=#value". 
The equation contains only '+', '-' operation, the variable x and its coefficient.
If there is no solution for the equation, return "No solution".
If there are infinite solutions for the equation, return "Infinite solutions".
If there is exactly one solution for the equation, we ensure that the value of x is an integer.

Example 1:
Input: "x+5-3+x=6+x-2"
Output: "x=2"

Example 2:
Input: "x=x"
Output: "Infinite solutions"

Example 3:
Input: "2x=x"
Output: "x=0"

Example 4:
Input: "2x+3x-6x=x+2"
Output: "x=-1"

Example 5:
Input: "x=x+2"
Output: "No solution"

*/

/*

O(n),O(1)

*/

public String solveEquation(String equation) {
    String[] s = equation.split("=");
    int[] left = count(s[0]);
    int[] right = count(s[1]);
    if (left[0] == right[0] && left[1] == right[1]) {
        return "Infinite solutions";
    } else if (left[0] == right[0] && left[1] != right[1]) {
        return "No solution";
    }
    return "x=" + ((right[1] - left[1]) / (left[0] - right[0]));
}

private int[] count(String s) {
    int[] ans = new int[2];
    int n = s.length();
    for (int i = 0, j = 1; j <= n; ++j) {
        if (j == n || s.charAt(j) == '+' || s.charAt(j) == '-') {
            if (s.charAt(j - 1) == 'x') {
                if (s.charAt(i) == '+') {
                    String num = s.substring(i + 1, j - 1);
                    ans[0] += Integer.valueOf(num.length() == 0 ? "1" : num);
                } else if (s.charAt(i) == '-') {
                    String num = s.substring(i + 1, j - 1);
                    ans[0] -= Integer.valueOf(num.length() == 0 ? "1" : num);
                } else {
                    String num = s.substring(i, j - 1);
                    ans[0] += Integer.valueOf(num.length() == 0 ? "1" : num);
                }
                i = j;
            } else {
                if (s.charAt(i) == '+') {
                    String num = s.substring(i + 1, j);
                    ans[1] += Integer.valueOf(num.length() == 0 ? "1" : num);
                } else if (s.charAt(i) == '-') {
                    String num = s.substring(i + 1, j);
                    ans[1] -= Integer.valueOf(num.length() == 0 ? "1" : num);
                } else {
                    String num = s.substring(i, j);
                    ans[1] += Integer.valueOf(num.length() == 0 ? "1" : num);
                }
                i = j;
            }
        }
    }
    return ans;
}




