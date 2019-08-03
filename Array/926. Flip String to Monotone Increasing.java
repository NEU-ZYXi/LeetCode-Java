
/*

A string of '0's and '1's is monotone increasing if it consists of some number of '0's (possibly 0), 
followed by some number of '1's (also possibly 0.)
We are given a string S of '0's and '1's, and we may flip any '0' to a '1' or a '1' to a '0'.
Return the minimum number of flips to make S monotone increasing.

Example 1:
Input: "00110"
Output: 1
Explanation: We flip the last digit to get 00111.

Example 2:
Input: "010110"
Output: 2
Explanation: We flip to get 011111, or alternatively 000111.

Example 3:
Input: "00011000"
Output: 2
Explanation: We flip to get 00000000.

*/

/*

Solution: count number of '1', or if s[i] is '0', first flip '0'
          if flip is larger than count of '1' which means number of flipped '0' is larger than number of '1', we flip '1' instead
O(n),O(1)          

*/

public int minFlipsMonoIncr(String S) {
    int one = 0, flip = 0;
    for (char c : S.toCharArray()) {
        if (c == '1') {
            one++;
        } else {
            if (one != 0) {
                flip++;
            }
        }
        flip = Math.min(flip, one);
    }
    return flip;
}




