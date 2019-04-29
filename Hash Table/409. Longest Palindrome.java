
/*

Given a string which consists of lowercase or uppercase letters, 
find the length of the longest palindromes that can be built with those letters.
This is case sensitive, for example "Aa" is not considered a palindrome here.

Example:
Input:
"abccccdd"
Output:
7
Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.

*/

/*

O(n),O(1)

*/

public int longestPalindrome(String s) {
    int[] buckets = new int[128];
    int ans = 0, mid = 0;
    for (char c : s.toCharArray()) buckets[c]++;
    for (int cnt : buckets) {
        if (cnt % 2 == 1) mid = 1;
        ans += cnt / 2 * 2;
    }
    return ans + mid;
}




