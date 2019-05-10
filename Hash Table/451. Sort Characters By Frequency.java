
/*

Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:
Input:
"tree"
Output:
"eert"
Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.

Example 2:
Input:
"cccaaa"
Output:
"cccaaa"
Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.

Example 3:
Input:
"Aabb"
Output:
"bbAa"
Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.

*/

/*

O(n),O(n)

*/

public String frequencySort(String s) {
    int n = s.length();
    int[] counts = new int[128];
    for (char c : s.toCharArray()) counts[c]++;
    List<Character>[] buckets = new ArrayList[n + 1];
    for (int i = 0; i < counts.length; ++i) {
        int cnt = counts[i];
        if (cnt != 0) {
            if (buckets[cnt] == null) buckets[cnt] = new ArrayList<>();
            buckets[cnt].add((char)i);
        }
    }
    StringBuilder ans = new StringBuilder();
    for (int i = n; i >= 1; --i) {
        if (buckets[i] != null) {
            for (char c : buckets[i]) {
                for (int j = 0; j < i; ++j) ans.append(c);
            }
        }
    }
    return ans.toString();
}





