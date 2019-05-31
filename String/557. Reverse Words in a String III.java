
/*

Given a string, you need to reverse the order of characters in each word within a sentence 
while still preserving whitespace and initial word order.

Example 1:
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"

*/

/*

O(n),O(n)

*/

public String reverseWords(String s) {
    int i = 0, j = 0, n = s.length();
    char[] chars = s.toCharArray();
    while (j < n) {
        while (j < n && s.charAt(j) != ' ') {
            j++;
        }
        reverse(chars, i, j - 1);
        j++;
        i = j;
    }
    return new String(chars);
}

private void reverse(char[] chars, int i, int j) {
    while (i < j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
        i++;
        j--;
    }
}




