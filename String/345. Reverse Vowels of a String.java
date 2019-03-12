
/*

Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
Input: "hello"
Output: "holle"

Example 2:
Input: "leetcode"
Output: "leotcede"

*/

/*

O(n),O(1)

*/

public String reverseVowels(String s) {
    char[] chars = s.toCharArray();
    int l = 0, r = chars.length - 1;
    while (l < r) {
        while (l < r && !isVowel(chars[l])) l++;
        while (l < r && !isVowel(chars[r])) r--;
        char tmp = chars[l];
        chars[l] = chars[r];
        chars[r] = tmp;
        l++;
        r--;
    }
    return new String(chars);
}

private boolean isVowel(char c) {
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || 
        c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
}




