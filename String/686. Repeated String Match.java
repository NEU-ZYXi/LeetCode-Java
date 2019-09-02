
/*

Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. 
If no such solution, return -1.
For example, with A = "abcd" and B = "cdabcdab".
Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; 
and B is not a substring of A repeated two times ("abcdabcd").

*/

/*

O(n),O(n)

*/

public int repeatedStringMatch(String A, String B) {
    StringBuilder sb = new StringBuilder(A);
    int ans = 1;
    while (sb.indexOf(B) == -1) {
        if (sb.length() > A.length() + B.length()) {
            return -1;
        }
        sb.append(A);
        ans++;
    }
    return ans;
}




