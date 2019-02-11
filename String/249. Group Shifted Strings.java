
/*

Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". 
We can keep "shifting" which forms the sequence:
"abc" -> "bcd" -> ... -> "xyz"
Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.

Example:
Input: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
Output: 
[
  ["abc","bcd","xyz"],
  ["az","ba"],
  ["acef"],
  ["a","z"]
]

*/

/*

O(nm),O(n), where n is the length of strings array and m is the average length of strings

*/

public List<List<String>> groupStrings(String[] strings) {
    Map<String, List<String>> map = new HashMap<>();
    for (String s : strings) {
        StringBuilder hash = new StringBuilder();
        for (int i = 1; i < s.length(); ++i) hash.append((s.charAt(i) - s.charAt(i - 1) + 26) % 26);
        map.putIfAbsent(hash.toString(), new ArrayList<>());
        map.get(hash.toString()).add(s);
    }
    return new ArrayList<>(map.values());
}



