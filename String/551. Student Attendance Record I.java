
/*

You are given a string representing an attendance record for a student. 
The record only contains the following three characters:
'A' : Absent.
'L' : Late.
'P' : Present.
A student could be rewarded if his record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).
You need to return whether the student could be rewarded according to his attendance record.

Example 1:
Input: "PPALLP"
Output: True

Example 2:
Input: "PPALLL"
Output: False

*/

/*

O(n),O(1)

*/

public boolean checkRecord(String s) {
    int A = 0, L = 0;
    for (int i = 0; i < s.length(); ++i) {
        if (s.charAt(i) == 'A') {
            if (A == 1) {
                return false;
            } else {
                A++;
            }
        }
        if (i > 0 && s.charAt(i) == 'L' && s.charAt(i - 1) == 'L') {
            if (L == 1) {
                return false;
            } else {
                L++;
            }
        } else {
            L = 0;
        }
    }
    return true;
}




