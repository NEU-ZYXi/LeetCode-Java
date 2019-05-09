
/*

Given an array of characters, compress it in-place.
The length after compression must always be smaller than or equal to the original array.
Every element of the array should be a character (not int) of length 1.
After you are done modifying the input array in-place, return the new length of the array.

Example 1:
Input:
["a","a","b","b","c","c","c"]
Output:
Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
Explanation:
"aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".
 
Example 2:
Input:
["a"]
Output:
Return 1, and the first 1 characters of the input array should be: ["a"]
Explanation:
Nothing is replaced.
 
Example 3:
Input:
["a","b","b","b","b","b","b","b","b","b","b","b","b"]
Output:
Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
Explanation:
Since the character "a" does not repeat, it is not compressed. "bbbbbbbbbbbb" is replaced by "b12".
Notice each digit has it's own entry in the array.

*/

/*

O(n),O(1)

*/

public int compress(char[] chars) {
    int i = 0, j = 0, n = chars.length;
    while (j < n) {
        int cnt = 0;
        char c = chars[j];
        while (j < n && chars[j] == c) {
            j++;
            cnt++;
        }
        chars[i++] = c;
        if (cnt != 1) {
            String digits = String.valueOf(cnt);
            for (char digit : digits.toCharArray()) chars[i++] = digit;
        }
    }
    return i;
}




