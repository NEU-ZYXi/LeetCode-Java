
/*

Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
If the fractional part is repeating, enclose the repeating part in parentheses.

Example 1:
Input: numerator = 1, denominator = 2
Output: "0.5"

Example 2:
Input: numerator = 2, denominator = 1
Output: "2"

Example 3:
Input: numerator = 2, denominator = 3
Output: "0.(6)"

*/

/*

O(1),O(k), where k is the number of decimals

*/

public String fractionToDecimal(int numerator, int denominator) {
    if (numerator == 0) return "0";
    StringBuilder ans = new StringBuilder();
    ans.append((numerator > 0) ^ (denominator > 0) ? "-" : "");
    long num = Math.abs((long)numerator), den = Math.abs((long)denominator);
    ans.append(num / den);
    long mod = num % den;
    if (mod == 0) return ans.toString();
    else ans.append(".");
    Map<Long, Integer> map = new HashMap<>();
    map.put(mod, ans.length());
    while (mod != 0) {
        mod *= 10;
        ans.append(mod / den);
        mod %= den;
        if (map.containsKey(mod)) {
            ans.insert(map.get(mod), "(").append(")");
            return ans.toString();
        }
        map.put(mod, ans.length());
    }
    return ans.toString();
}



