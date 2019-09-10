
/*

Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.

Example 1:
Input: "Hello"
Output: "hello"

Example 2:
Input: "here"
Output: "here"

Example 3:
Input: "LOVELY"
Output: "lovely"

*/

/*

O(n),O(n)

*/

public String toLowerCase(String str) {
    char[] chars = str.toCharArray();
    for (int i = 0; i < chars.length; ++i) {
        if (chars[i] >= 'A' && chars[i] <= 'Z') {
            chars[i] += 32;
        }
    }
    return new String(chars);
}




