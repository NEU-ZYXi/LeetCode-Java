
/*

Given an array A of strings made only from lowercase letters, 
return a list of all characters that show up in all strings within the list (including duplicates).  
For example, if a character occurs 3 times in all strings but not 4 times, 
you need to include that character three times in the final answer.
You may return the answer in any order.

Example 1:
Input: ["bella","label","roller"]
Output: ["e","l","l"]

Example 2:
Input: ["cool","lock","cook"]
Output: ["c","o"]

*/

/*

O(n),O(n)

*/

public List<String> commonChars(String[] A) {
    List<String> ans = new ArrayList<>();
    int[] buckets = new int[26];
    Arrays.fill(buckets, Integer.MAX_VALUE);
    for (String a : A) {
        int[] cnt = new int[26];
        for (int i = 0; i < a.length(); ++i) {
            cnt[a.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; ++i) {
            buckets[i] = Math.min(buckets[i], cnt[i]);
        }
    }
    for (int i = 0; i < 26; ++i) {
        while (buckets[i] > 0) {
            ans.add(String.valueOf((char)(i + 'a')));
            buckets[i]--;
        }
    }
    return ans;
}



