
/*

The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.

Example 1:
Input: 1
Output: "1"

Example 2:
Input: 4
Output: "1211"

*/

/*

O(nm),O(n), where m is the average length of each step string

*/

public String countAndSay(int n) {
    String ans = "1";
    for (int i = 1; i < n; ++i) {
        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        for (int j = 1; j <= ans.length(); ++j) {
            if (j == ans.length() || ans.charAt(j) != ans.charAt(j - 1)) {
                sb.append(String.valueOf(cnt)).append(ans.charAt(j - 1));
                cnt = 1;
            } else cnt++;
        }
        ans = sb.toString();
    }
    return ans;
}



