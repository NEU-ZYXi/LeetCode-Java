
/*

You are given an integer array nums and you have to return a new counts array. 
The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

Example:
Input: [5,2,6,1]
Output: [2,1,1,0] 
Explanation:
To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.

*/

/*

Solution: 1. sort the array with a copy and use a map to discretize all numbers
          2. build the segment tree
          3. for each number in reversed order, get its index in the map, query in the range [0...idx-1]
          4. update the count in the range [0...idx]
O(nlogn) build, O(logn) update and query, O(n)          

*/

class Node {
    private int l, r, cnt;

    public Node(int _l, int _r, int _cnt) {
        this.l = _l;
        this.r = _r;
        this.cnt = _cnt;
    }
}

public List<Integer> countSmaller(int[] nums) {
    List<Integer> ans = new ArrayList<>();
    int n = nums.length;
    if (n == 0) return ans;
    Node[] segTree = new Node[n << 2];
    int[] sorted = Arrays.copyOf(nums, n);
    Arrays.sort(sorted);
    Map<Integer, Integer> map = new HashMap<>();
    int tot = 0;
    for (int num : sorted) map.put(num, ++tot);
    build(segTree, 1, 0, n);
    for (int i = n - 1; i >= 0; --i) {
        int idx = map.get(nums[i]);
        ans.add(0, query(segTree, 1, 0, idx - 1));
        update(segTree, 1, idx);
    }
    return ans;
}

private void build(Node[] segTree, int i, int l, int r) {
    segTree[i] = new Node(l, r, 0);
    if (l == r) return;
    int mid = (l + r) / 2;
    build(segTree, i << 1, l, mid);
    build(segTree, (i << 1) | 1, mid + 1, r);
}

private void update(Node[] segTree, int i, int idx) {
    if (segTree[i].l == segTree[i].r) {
        segTree[i].cnt++;
        return;
    }
    int mid = (segTree[i].l + segTree[i].r) / 2;
    if (idx <= mid) update(segTree, i << 1, idx);
    else update(segTree, (i << 1) | 1, idx);
    segTree[i].cnt = segTree[i << 1].cnt + segTree[(i << 1) | 1].cnt;
}

private int query(Node[] segTree, int i, int l, int r) {
    if (segTree[i].l == l && segTree[i].r == r) return segTree[i].cnt;
    int mid = (segTree[i].l + segTree[i].r) / 2;
    if (l > mid) return query(segTree, (i << 1) | 1, l, r);
    else if (r <= mid) return query(segTree, i << 1, l, r);
    else return query(segTree, i << 1, l, mid) + query(segTree, (i << 1) | 1, mid + 1, r);
}




