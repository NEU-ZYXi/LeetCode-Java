
/*

A gene string can be represented by an 8-character long string, with choices from "A", "C", "G", "T".
Suppose we need to investigate about a mutation (mutation from "start" to "end"), 
where ONE mutation is defined as ONE single character changed in the gene string.
For example, "AACCGGTT" -> "AACCGGTA" is 1 mutation.
Also, there is a given gene "bank", which records all the valid gene mutations. 
A gene must be in the bank to make it a valid gene string.
Now, given 3 things - start, end, bank, your task is to determine 
what is the minimum number of mutations needed to mutate from "start" to "end". 
If there is no such a mutation, return -1.

Example 1:
start: "AACCGGTT"
end:   "AACCGGTA"
bank: ["AACCGGTA"]
return: 1

Example 2:
start: "AACCGGTT"
end:   "AAACGGTA"
bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
return: 2

Example 3:
start: "AAAAACCC"
end:   "AACCCCCC"
bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
return: 3

*/

/*

O(nm),O(n) where n is average depth and m is average length of strings

*/

private char[] options = new char[] {'A', 'C', 'G', 'T'};
    
public int minMutation(String start, String end, String[] bank) {
    Queue<String> queue = new LinkedList<>();
    Set<String> dict = new HashSet<>();
    Set<String> vis = new HashSet<>();
    for (String s : bank) dict.add(s);
    int ans = 0;
    queue.offer(start);
    vis.add(start);
    while (!queue.isEmpty()) {
        int size = queue.size();
        for (int i = 0; i < size; ++i) {
            String cur = queue.poll();
            if (cur.equals(end)) return ans;
            for (int j = 0; j < cur.length(); ++j) {
                char[] chars = cur.toCharArray();
                for (char option : options) {
                    if (chars[j] != option) {
                        chars[j] = option;
                        String nxt = new String(chars);
                        if (dict.contains(nxt) && vis.add(nxt)) queue.offer(nxt);
                    }
                }
            }
        }
        ans++;
    }
    return -1;
}




