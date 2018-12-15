
/*

Given an array of strings, group anagrams together.

Example:
Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]

*/

/*

O(nmlogm),O(nm), where m is the average length of the strings

*/

public List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> ans = new ArrayList<>();
    Map<String, List<String>> map = new HashMap<>();
    for (String s : strs) {
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        String key = new String(ch);
        List<String> values = map.getOrDefault(key, new ArrayList<>());
        values.add(s);
        map.put(key, values);
    }
    for (String key : map.keySet()) ans.add(map.get(key));
    return ans;
}




