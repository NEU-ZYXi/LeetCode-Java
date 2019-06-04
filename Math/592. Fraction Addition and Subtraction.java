
/*

Given a string representing an expression of fraction addition and subtraction, 
you need to return the calculation result in string format. 
The final result should be irreducible fraction. 
If your final result is an integer, say 2, you need to change it to the format of fraction that has denominator 1. 
So in this case, 2 should be converted to 2/1.

Example 1:
Input:"-1/2+1/2"
Output: "0/1"

Example 2:
Input:"-1/2+1/2+1/3"
Output: "1/3"

Example 3:
Input:"1/3-1/2"
Output: "-1/6"

Example 4:
Input:"5/3+1/3"
Output: "2/1"

*/

/*

O(n),O(n)

*/

public String fractionAddition(String expression) {
    List<String> nums = new ArrayList<>();
    int i = 0, j = 1, n = expression.length();
    String ans = "0/1";
    while (j <= n) {
        if (j == n || expression.charAt(j) == '+' || expression.charAt(j) == '-') {
            nums.add(expression.substring(i, j));
            i = j;
        }
        j++;
    }
    for (String num : nums) {
        ans = add(ans, num);
    }
    return ans;
}

private String add(String s1, String s2) {
    String[] a = s1.split("/"), b = s2.split("/");
    int sign1 = 1, sign2 = 1;
    if (a[0].charAt(0) == '+' || a[0].charAt(0) == '-') {
        sign1 = a[0].charAt(0) == '+' ? 1 : -1;
        a[0] = a[0].substring(1);
    }
    if (b[0].charAt(0) == '+' || b[0].charAt(0) == '-') {
        sign2 = b[0].charAt(0) == '+' ? 1 : -1;
        b[0] = b[0].substring(1);
    }
    int n1 = Integer.valueOf(a[0]), d1 = Integer.valueOf(a[1]), n2 = Integer.valueOf(b[0]), d2 = Integer.valueOf(b[1]);
    int ans = sign1 * n1 * d2 + sign2 * n2 * d1, d = d1 * d2;
    if (ans == 0) {
        return "0/1";
    }
    int gcd = GCD(Math.abs(ans), d);
    return (ans / gcd) + "/" + (d / gcd);
}

private int GCD(int a, int b) {
    return b == 0 ? a : GCD(b, a % b);
}




