
/*

Given an input string , reverse the string word by word. 

Example:
Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]

Note: 
A word is defined as a sequence of non-space characters.
The input string does not contain leading or trailing spaces.
The words are always separated by a single space.

*/

/*

O(n),O(1)

*/

public void reverseWords(char[] str) {
    int n = str.length;
    reverse(str, 0, n - 1);
    for (int i = 0, j = 0; j <= n; ++j) {
        if (j == n || str[j] == ' ') {
            reverse(str, i, j - 1);
            i = j + 1;
        }
    }
}

private void reverse(char[] s, int i, int j) {
    while (i < j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
        i++;
        j--;
    }
}




