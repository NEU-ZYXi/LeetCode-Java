
/*

Given a valid (IPv4) IP address, return a defanged version of that IP address.
A defanged IP address replaces every period "." with "[.]".

Example 1:
Input: address = "1.1.1.1"
Output: "1[.]1[.]1[.]1"

Example 2:
Input: address = "255.100.50.0"
Output: "255[.]100[.]50[.]0"

*/

/*

O(1),O(1)

*/

public String defangIPaddr(String address) {
    String[] ips = address.split("\\.");
    StringBuilder ans = new StringBuilder();
    for (String ip : ips) {
        ans.append(ip).append("[.]");
    }
    ans.setLength(ans.length() - 3);
    return ans.toString();
}


