
/*

Given a string containing only digits, restore it by returning all possible valid IP address combinations.

Example:
Input: "25525511135"
Output: ["255.255.11.135", "255.255.111.35"]

*/

/*

O(3^n),O(n), where n is the number of IP sections, here it's 4Given a string containing only digits, restore it by returning all possible valid IP address combinations.

Example:

Input: "25525511135"
Output: ["255.255.11.135", "255.255.111.35"]

*/

public List<String> restoreIpAddresses(String s) {
    List<String> ans = new ArrayList<>();
    dfs(ans, "", s, 0, 0);
    return ans;
}

private void dfs(List<String> ans, String tmp, String s, int idx, int cnt) {
    if (cnt == 4) {
        if (idx == s.length()) ans.add(tmp);
        return;
    }
    for (int i = 1; i < 4; ++i) {
        if (idx + i > s.length()) break;
        String ip = s.substring(idx, idx + i);
        if (ip.length() > 1 && ip.charAt(0) == '0' || Integer.valueOf(ip) > 255) continue;
        dfs(ans, tmp + ip + (cnt == 3 ? "" : "."), s, idx + i, cnt + 1);
    }
}




