
/*

Given two strings str1 and str2 of the same length, 
determine whether you can transform str1 into str2 by doing zero or more conversions.
In one conversion you can convert all occurrences of one character in str1 to any other lowercase English character.
Return true if and only if you can transform str1 into str2.

Example 1:
Input: str1 = "aabcc", str2 = "ccdee"
Output: true
Explanation: Convert 'c' to 'e' then 'b' to 'd' then 'a' to 'c'. Note that the order of conversions matter.

Example 2:
Input: str1 = "leetcode", str2 = "codeleet"
Output: false
Explanation: There is no way to transform str1 to str2.

*/

/*

Solution: for circular transformation like a->b->c->a, we need an unused character as tmp to make this transformation
          so, first check whether we could find at least one unused character in str2
          then for each character in str1, it can only map to the same character
O(n),O(n)          

*/

public boolean canConvert(String str1, String str2) {
    if (str1.equals(str2)) {
        return true;
    }
    Set<Character> chars = new HashSet<>();
    for (char c : str2.toCharArray()) {
        chars.add(c);
    }
    if (chars.size() == 26) {
        return false;
    }
    Map<Character, Character> map = new HashMap<>();
    for (int i = 0; i < str1.length(); ++i) {
        char c1 = str1.charAt(i), c2 = str2.charAt(i);
        if (map.getOrDefault(c1, c2) != c2) {
            return false;
        }
        map.put(c1, c2);
    }
    return true;
}




