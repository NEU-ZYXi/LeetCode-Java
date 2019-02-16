
/*

Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.

Example 1:
Input: 123
Output: "One Hundred Twenty Three"

Example 2:
Input: 12345
Output: "Twelve Thousand Three Hundred Forty Five"

Example 3:
Input: 1234567
Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"

Example 4:
Input: 1234567891
Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"

*/

/*

O(1),O(1)

*/

private String[] digits = 
  new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
private String[] tens = 
  new String[] {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
private String[] dozens = 
  new String[] {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

public String numberToWords(int num) {
    if (num == 0) return "Zero";
    return solve(num);
}

private String solve(int num) {
    String ans = "";
    if (num < 10) ans = digits[num];
    else if (num < 20) ans = tens[num - 10];
    else if (num < 100) ans = dozens[num / 10] + " " + solve(num % 10);
    else if (num < 1000) ans = solve(num / 100) + " Hundred " + solve(num % 100);
    else if (num < 1000000) ans = solve(num / 1000) + " Thousand " + solve(num % 1000);
    else if (num < 1000000000) ans = solve(num / 1000000) + " Million " + solve(num % 1000000);
    else ans = solve(num / 1000000000) + " Billion " + solve(num % 1000000000);
    ans = ans.trim();
    return ans;
}




