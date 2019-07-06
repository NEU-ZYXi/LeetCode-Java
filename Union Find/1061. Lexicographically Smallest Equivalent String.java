
/*

Given strings A and B of the same length, we say A[i] and B[i] are equivalent characters. 
For example, if A = "abc" and B = "cde", then we have 'a' == 'c', 'b' == 'd', 'c' == 'e'.
Equivalent characters follow the usual rules of any equivalence relation:
Reflexivity: 'a' == 'a'
Symmetry: 'a' == 'b' implies 'b' == 'a'
Transitivity: 'a' == 'b' and 'b' == 'c' implies 'a' == 'c'
For example, given the equivalency information from A and B above, 
S = "eed", "acd", and "aab" are equivalent strings, and "aab" is the lexicographically smallest equivalent string of S.
Return the lexicographically smallest equivalent string of S by using the equivalency information from A and B.

Example 1:
Input: A = "parker", B = "morris", S = "parser"
Output: "makkek"
Explanation: Based on the equivalency information in A and B, we can group their characters as [m,p], [a,o], [k,r,s], [e,i].
The characters in each group are equivalent and sorted in lexicographical order. So the answer is "makkek".

Example 2:
Input: A = "hello", B = "world", S = "hold"
Output: "hdld"
Explanation:  Based on the equivalency information in A and B, we can group their characters as [h,w], [d,e,o], [l,r].
So only the second letter 'o' in S is changed to 'd', the answer is "hdld".

Example 3:
Input: A = "leetcode", B = "programs", S = "sourcecode"
Output: "aauaaaaada"
Explanation:  We group the equivalent characters in A and B as [a,o,e,r,s,c], [l,p], [g,t] and [d,m],
thus all letters in S except 'u' and 'd' are transformed to 'a', the answer is "aauaaaaada".

*/

/*

O(n),O(n)

*/

class UnionFind {
    private int[] parent;

    public UnionFind() {
        this.parent = new int[26];
        for (int i = 0; i < 26; ++i) {
            this.parent[i] = i;
        }
    }

    public int find(int i) {
        if (i != parent[i]) {
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }

    public void union(int p, int q) {
        int rootP = find(p), rootQ = find(q);
        if (rootP == rootQ) {
            return;
        } else if (rootP < rootQ) {
            parent[rootQ] = parent[rootP];
        } else {
            parent[rootP] = parent[rootQ];
        }
    }
}

public String smallestEquivalentString(String A, String B, String S) {
    UnionFind uf = new UnionFind();
    StringBuilder ans = new StringBuilder();
    for (int i = 0; i < A.length(); ++i) {
        char a = A.charAt(i), b = B.charAt(i);
        uf.union(a - 'a', b - 'a');
    }
    for (char c : S.toCharArray()) {
        int cur = uf.find(c - 'a');
        ans.append((char)(cur + 'a'));
    }
    return ans.toString();
}




