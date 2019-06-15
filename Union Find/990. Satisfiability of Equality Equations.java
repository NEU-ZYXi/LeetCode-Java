
/*

Given an array equations of strings that represent relationships between variables, 
each string equations[i] has length 4 and takes one of two different forms: "a==b" or "a!=b".  
Here, a and b are lowercase letters (not necessarily different) that represent one-letter variable names.
Return true if and only if it is possible to assign integers to variable names so as to satisfy all the given equations.

Example 1:
Input: ["a==b","b!=a"]
Output: false
Explanation: If we assign say, a = 1 and b = 1, then the first equation is satisfied, but not the second.  
There is no way to assign the variables to satisfy both equations.

Example 2:
Input: ["b==a","a==b"]
Output: true
Explanation: We could assign a = 1 and b = 1 to satisfy both equations.

Example 3:
Input: ["a==b","b==c","a==c"]
Output: true

Example 4:
Input: ["a==b","b!=c","c==a"]
Output: false

Example 5:
Input: ["c==c","b==d","x!=z"]
Output: true

*/

/*

O(n),O(n)

*/

class UF {
    private int[] parent;
    private int[] rank;

    public UF(int n) {
        this.parent = new int[n];
        this.rank = new int[n];
        for (int i = 0; i < n; ++i) {
            this.parent[i] = i;
            this.rank[i] = 1;
        }
    }

    private int find(int i) {
        while(i != parent[i]) {
            i = parent[i];
            parent[i] = parent[parent[i]];
        }
        return i;
    }

    private void union(int p, int q) {
        int rootP = find(p), rootQ = find(q);
        if (rootP == rootQ) {
            return;
        } else if (rank[rootP] > rank[rootQ]) {
            rank[rootP] += rank[rootQ];
            parent[rootQ] = parent[rootP];
        } else {
            rank[rootQ] += rank[rootP];
            parent[rootP] = parent[rootQ];
        }
    }
}

public boolean equationsPossible(String[] equations) {
    UF uf = new UF(26);
    for (String eq : equations) {
        if (eq.charAt(1) == '=') {
            char p = eq.charAt(0), q = eq.charAt(3);
            uf.union(p - 'a', q - 'a');
        }
    }
    for (String eq : equations) {
        if (eq.charAt(1) == '!') {
            char p = eq.charAt(0), q = eq.charAt(3);
            if (uf.find(p - 'a') == uf.find(q - 'a')) {
                return false;
            }
        }
    }
    return true;
}



