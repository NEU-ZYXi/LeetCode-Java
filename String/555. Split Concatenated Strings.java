
/*

Given a list of strings, you could concatenate these strings together into a loop, 
where for each string you could choose to reverse it or not. 
Among all the possible loops, you need to find the lexicographically biggest string after cutting the loop, 
which will make the looped string into a regular one.
Specifically, to find the lexicographically biggest string, you need to experience two phases:
Concatenate all the strings into a loop, where you can reverse some strings or not and connect them in the same order as given.
Cut and make one breakpoint in any place of the loop, 
which will make the looped string into a regular one starting from the character at the cutpoint.
And your job is to find the lexicographically biggest one among all the possible regular strings.

Example:
Input: "abc", "xyz"
Output: "zyxcba"
Explanation: You can get the looped string "-abcxyz-", "-abczyx-", "-cbaxyz-", "-cbazyx-", 
where '-' represents the looped status. 
The answer string came from the fourth looped one, 
where you could cut from the middle character 'a' and get "zyxcba".

*/

/*

O(mn^2),O(n) where n is length of strs and m is average length of strings

*/

public String splitLoopedString(String[] strs) {
    char max = 'a';
    int n = strs.length;
    for (int i = 0; i < n; ++i) {
        for (char c : strs[i].toCharArray()) {
            if (max < c) {
                max = c;
            }
        }
        String reverse = new StringBuilder(strs[i]).reverse().toString();
        if (strs[i].compareTo(reverse) < 0) {
            strs[i] = reverse;
        }
    }
    String ans = "";
    for (int i = 0; i < n; ++i) {
        String reverse = new StringBuilder(strs[i]).reverse().toString();
        for (String s : new String[] {strs[i], reverse}) {
            for (int j = 0; j < s.length(); ++j) {
                if (s.charAt(j) == max) {
                    StringBuilder cur = new StringBuilder(s.substring(j));
                    for (int k = i + 1; k < n; ++k) {
                        cur.append(strs[k]);
                    }
                    for (int k = 0; k < i; ++k) {
                        cur.append(strs[k]);
                    }
                    cur.append(s.substring(0, j));
                    if (ans.compareTo(cur.toString()) < 0) {
                        ans = cur.toString();
                    }
                }
            }
        }
    }
    return ans;
}





