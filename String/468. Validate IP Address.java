
/*

Write a function to check whether an input string is a valid IPv4 address or IPv6 address or neither.
IPv4 addresses are canonically represented in dot-decimal notation, which consists of four decimal numbers, 
each ranging from 0 to 255, separated by dots ("."), e.g.,172.16.254.1;
Besides, leading zeros in the IPv4 is invalid. For example, the address 172.16.254.01 is invalid.
IPv6 addresses are represented as eight groups of four hexadecimal digits, each group representing 16 bits. 
The groups are separated by colons (":"). For example, the address 2001:0db8:85a3:0000:0000:8a2e:0370:7334 is a valid one. 
We could omit some leading zeros among four hexadecimal digits and some low-case characters in the address to upper-case ones, 
so 2001:db8:85a3:0:0:8A2E:0370:7334 is also a valid IPv6 address(Omit leading zeros and using upper cases).
Don't replace a consecutive group of zero value with a single empty group using two consecutive colons (::) to pursue simplicity. 
For example, 2001:0db8:85a3::8A2E:0370:7334 is an invalid IPv6 address.
Besides, extra leading zeros in the IPv6 is also invalid. 
For example, the address 02001:0db8:85a3:0000:0000:8a2e:0370:7334 is invalid.
Note: You may assume there is no extra space or special characters in the input string.

Example 1:
Input: "172.16.254.1"
Output: "IPv4"
Explanation: This is a valid IPv4 address, return "IPv4".

Example 2:
Input: "2001:0db8:85a3:0:0:8A2E:0370:7334"
Output: "IPv6"
Explanation: This is a valid IPv6 address, return "IPv6".

Example 3:
Input: "256.256.256.256"
Output: "Neither"
Explanation: This is neither a IPv4 address nor a IPv6 address.

*/

/*

O(n),O(1)

*/

public String validIPAddress(String IP) {
    if (IP.length() < 7) return "Neither";
    if (isIPv4(IP)) return "IPv4";
    if (isIPv6(IP)) return "IPv6";
    return "Neither";
}

private boolean isIPv4(String IP) {
    if (IP.charAt(0) == '.' || IP.charAt(IP.length() - 1) == '.') return false;
    String[] strs = IP.split("\\.");
    if (strs.length != 4) return false;
    for (String s : strs) {
        if (s.length() == 0 || s.length() > 3) return false;
        if (s.charAt(0) == '0' && s.length() > 1) return false;
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        if (Integer.valueOf(s) > 255) return false;
    }
    return true;
}

private boolean isIPv6(String IP) {
    if (IP.charAt(0) == ':' || IP.charAt(IP.length() - 1) == ':') return false;
    String[] strs = IP.split("\\:");
    if (strs.length != 8) return false;
    for (String s : strs) {
        if (s.length() == 0 || s.length() > 4) return false;
        for (char c : s.toCharArray()) {
            System.out.println(c);
            if (!(('0' <= c && c <= '9') || ('a' <= c && c <= 'f') || ('A' <= c && c <= 'F'))) return false;
        }
    }
    return true;
}




