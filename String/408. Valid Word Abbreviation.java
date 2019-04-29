
/*

Given a non-empty string s and an abbreviation abbr, return whether the string matches with the given abbreviation.
A string such as "word" contains only the following valid abbreviations:
["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
Notice that only the above abbreviations are valid abbreviations of the string "word". 
Any other string is not a valid abbreviation of "word".
Note:
Assume s contains only lowercase letters and abbr contains only lowercase letters and digits.

Example 1:
Given s = "internationalization", abbr = "i12iz4n":
Return true.

Example 2:
Given s = "apple", abbr = "a2e":
Return false.

*/

/*

O(n),O(1)

*/

public boolean validWordAbbreviation(String word, String abbr) {
    int i = 0, j = 0;
    while (i < word.length() && j < abbr.length()) {
        char a = word.charAt(i), b = abbr.charAt(j);
        if (Character.isLetter(b)) {
            if (a != b) return false;
            i++;
            j++;
        } else {
            if (b <= '0' || b >= '9') return false;
            int tmp = j;
            while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) j++;
            int num = Integer.valueOf(abbr.substring(tmp, j));
            i += num;
            if (j == abbr.length()) break;
        }
    }
    return i == word.length() && j == abbr.length();
}




