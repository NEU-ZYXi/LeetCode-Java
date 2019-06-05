
/*

Given a positive integer n, find the number of non-negative integers less than or equal to n, 
whose binary representations do NOT contain consecutive ones.

Example 1:
Input: 5
Output: 5
Explanation: 
Here are the non-negative integers <= 5 with their corresponding binary representations:
0 : 0
1 : 1
2 : 10
3 : 11
4 : 100
5 : 101
Among them, only integer 3 disobeys the rule (two consecutive ones) and the other 5 satisfy the rule. 

*/

/*

Solution: count the non-consecutive ones numbers and subtract the numbers larger than given number
          zero[i] means the number of non-consecutive ones numbers with ith bit is '0'
          one[i] means the number of non-consecutive ones numbers with ith bit is '1'
          for the binary number, if s[i]=s[i-1]='1' which means ...11..., all the remaining numbers are smaller, stop subtraction
          if s[i]=s[i-1]='0' which means ...00..., the numbers with ...01... should be subtracted which is one[n-i-1]
          since reverse 1... to count, '1' is (i+1)th bit and we have (n-i-1) bits remaining, the number of ...1 is one[n-i-1]
          ...00... is the only subtraction, because for ...01... or ...10..., the larger numbers with ...11... are invalid
O(n),O(n)          

*/

public int findIntegers(int num) {
    String s = Integer.toBinaryString(num);
    int n = s.length();
    int[] zero = new int[n];
    int[] one = new int[n];
    zero[0] = 1;
    one[0] = 1;
    for (int i = 1; i < n; ++i) {
        zero[i] = zero[i - 1] + one[i - 1];
        one[i] = zero[i - 1];
    }
    int ans = zero[n - 1] + one[n - 1];
    for (int i = 1; i < n; ++i) {
        if (s.charAt(i) == '1' && s.charAt(i - 1) == '1') {
            break;
        }
        if (s.charAt(i) == '0' && s.charAt(i - 1) == '0') {
            ans -= one[n - i - 1];
        }
    }
    return ans;
}




