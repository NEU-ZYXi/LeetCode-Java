
/*

All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". 
When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

Example:
Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
Output: ["AAAAACCCCC", "CCCCCAAAAA"]

*/

/*

Solution 1: use two hashsets of string to store the current string as visited, if it repeats, add it in the ans set
O(n),O(n)

*/

public List<String> findRepeatedDnaSequences(String s) {
    Set<String> visited = new HashSet<>(), ans = new HashSet<>();
    for (int i = 0; i < s.length() - 9; ++i) {
        String cur = s.substring(i, i + 10);
        if (!visited.add(cur)) ans.add(cur);
    }
    return new ArrayList<>(ans);
}


/*

Solution 2: use bit manipulations to represent the string
            C-A=01, G-A=10, T-A=11
            for each letter, val<<=2 means go to the next two digits and store the current letter by val|=map[letter-A]
O(n),O(n)            

*/

public List<String> findRepeatedDnaSequences(String s) {
    List<String> ans = new ArrayList<>();
    Set<Integer> visited = new HashSet<>();
    Set<Integer> repeat = new HashSet<>();
    char[] map = new char[26];
    map['C' - 'A'] = 1;
    map['G' - 'A'] = 2;
    map['T' - 'A'] = 3;
    for (int i = 0; i < s.length() - 9; ++i) {
        int val = 0;
        for (int j = i; j < i + 10; ++j) {
            val <<= 2;
            val |= map[s.charAt(j) - 'A'];
        }
        if (!visited.add(val) && repeat.add(val)) ans.add(s.substring(i, i + 10));
    }
    return ans;
}




