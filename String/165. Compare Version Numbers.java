
/*

Compare two version numbers version1 and version2.
If version1 > version2 return 1; if version1 < version2 return -1;otherwise return 0.
You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", 
it is the fifth second-level revision of the second first-level revision.

You may assume the default revision number for each level of a version number to be 0. 
For example, version number 3.4 has a revision number of 3 and 4 for its first and second level revision number. 
Its third and fourth level revision number are both 0.

Example 1:
Input: version1 = "0.1", version2 = "1.1"
Output: -1

Example 2:
Input: version1 = "1.0.1", version2 = "1"
Output: 1

Example 3:
Input: version1 = "7.5.2.4", version2 = "7.5.3"
Output: -1

Example 4:
Input: version1 = "1.01", version2 = "1.001"
Output: 0
Explanation: Ignoring leading zeroes, both “01” and “001" represent the same number “1”

*/

/*

O(n),O(1)

*/

public int compareVersion(String version1, String version2) {
    int i = 0, j = 0;
    while (i < version1.length() || j < version2.length()) {
        int v1 = 0, v2 = 0;
        while (i < version1.length() && version1.charAt(i) != '.') {
            v1 *= 10;
            v1 += version1.charAt(i) - '0';
            i++;
        }
        while (j < version2.length() && version2.charAt(j) != '.') {
            v2 *= 10;
            v2 += version2.charAt(j) - '0';
            j++;
        }
        if (v1 != v2) return v1 > v2 ? 1 : -1;
        i++;
        j++;
    }
    return 0;
}




