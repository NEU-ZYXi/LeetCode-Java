
/*

Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.
Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.

Example:
Input: [3, 10, 5, 25, 2, 8]
Output: 28
Explanation: The maximum result is 5 ^ 25 = 28.

*/

/*

Solution 1: build a bit Trie for all numbers, for each number, greedily go to the path which can form more 1 bits
O(n),O(n)

*/

class TrieNode {
    private TrieNode[] children;

    public TrieNode() {
        this.children = new TrieNode[2];
    }
}

public int findMaximumXOR(int[] nums) {
    if (nums.length == 0) return 0;
    TrieNode root = new TrieNode();
    for (int num : nums) {
        TrieNode cur = root;
        for (int i = 31; i >= 0; --i) {
            int curBit = (num >>> i) & 1;
            if (cur.children[curBit] == null) cur.children[curBit] = new TrieNode();
            cur = cur.children[curBit];
        }
    }
    int ans = 0;
    for (int num : nums) {
        TrieNode cur = root;
        int sum = 0;
        for (int i = 31; i >= 0; --i) {
            int curBit = (num >>> i) & 1;
            if (cur.children[curBit ^ 1] == null) cur = cur.children[curBit];
            else {
                sum += (1 << i);
                cur = cur.children[curBit ^ 1];
            }
        }
        ans = Math.max(ans, sum);
    }
    return ans;
}


/*

Solution 2: use a hashset to implement the same logics as above, greedily get the largest prefix and form the final number
O(n),O(n)

*/

public int findMaximumXOR(int[] nums) {
    int ans = 0, mask = 0;
    for (int i = 31; i >= 0; --i) {
        mask = mask | (1 << i);
        int tmp = ans | (1 << i);
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            num &= mask;
            if (set.contains(tmp ^ num)) {
                ans = tmp;
                break;
            }
            set.add(num);
        }
    }
    return ans;
}





