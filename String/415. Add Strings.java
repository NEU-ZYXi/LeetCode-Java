
/*

Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

*/

/*

O(n1+n2),O(1)

*/

public String addStrings(String num1, String num2) {
    String ans = "";
    int sum = 0, n1 = num1.length(), n2 = num2.length();
    while (n1 > 0 || n2 > 0) {
        sum /= 10;
        if (n1 > 0) {
            sum += num1.charAt(n1 - 1) - '0';
            n1--;
        } 
        if (n2 > 0) {
            sum += num2.charAt(n2 - 1) - '0';
            n2--;
        }
        ans = (sum % 10) + ans;
    }
    if (sum >= 10) ans = "1" + ans;
    return ans;
}




