
/*

Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, 
so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.

Example 1:
Input: ["abcd","dcba","lls","s","sssll"]
Output: [[0,1],[1,0],[3,2],[2,4]] 
Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]

Example 2:
Input: ["bat","tab","cat"]
Output: [[0,1],[1,0]] 
Explanation: The palindromes are ["battab","tabbat"]

*/

/*

Solution 1: use hash table to store all strings with their index
            for each string, separate it into two parts l and r
            1. if l is palindrome, which means reversed(r)+l+r is palindrome, find reversed(r) in hash table
            2. if r is palindrome, which means l+r+reversed(l) is palindrome, find reversed(l) in hash table
O(nm^3),O(n), where n is length of words array and m is average length of words            

*/

public List<List<Integer>> palindromePairs(String[] words) {
    List<List<Integer>> ans = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < words.length; ++i) map.put(words[i], i);
    for (int i = 0; i < words.length; ++i) {
        for (int j = 0; j <= words[i].length(); ++j) {
            String l = words[i].substring(0, j);
            String r = words[i].substring(j);
            if (isPalindrome(l)) {
                String target = new StringBuilder(r).reverse().toString();
                if (map.containsKey(target) && map.get(target) != i) ans.add(Arrays.asList(map.get(target), i));
            }
            if (isPalindrome(r) && r.length() != 0) {
                String target = new StringBuilder(l).reverse().toString();
                if (map.containsKey(target) && map.get(target) != i) ans.add(Arrays.asList(i, map.get(target)));
            }
        }
    }
    return ans;
}

private boolean isPalindrome(String s) {
    int l = 0, r = s.length() - 1;
    while (l < r) {
        if (s.charAt(l) != s.charAt(r)) return false;
        l++;
        r--;
    }
    return true;
}


/*

Solution 2: 

*/





