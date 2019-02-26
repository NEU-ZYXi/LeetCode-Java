
/*

Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
The update(i, val) function modifies nums by updating the element at index i to val.

Example:
Given nums = [1, 3, 5]
sumRange(0, 2) -> 9
update(1, 2)
sumRange(0, 2) -> 8

*/

/*

Solution 1: use binary indexed tree (BIT) to preprocess and implement online update and query
            in BIT, use lowbit (x&(-x)) to go through a path
O(nlogn) build, O(logn) update and query, O(n)

*/

class NumArray {
    
    private int[] nums;
    private int[] BIT;

    public NumArray(int[] nums) {
        int n = nums.length;
        if (n == 0) return;
        this.nums = new int[n];
        this.BIT = new int[n + 1];
        for (int i = 0; i < n; ++i) update(i, nums[i]);
    }
    
    private int lowbit(int x) {
        return x & (-x);
    }
    
    public void update(int i, int val) {
        for (int x = i + 1; x <= nums.length; x += lowbit(x)) BIT[x] += val - nums[i];
        nums[i] = val;
    }
    
    public int sumRange(int i, int j) {
        return query(j + 1) - query(i);
    }
    
    private int query(int i) {
        int ans = 0;
        for (int x = i; x > 0; x -= lowbit(x)) ans += BIT[x];
        return ans;
    }
}


/*

Solution 2: build segment tree to implement online update and query, comments inline
O(nlogn) build, O(logn) update and query, O(n)

*/

class NumArray {
    
    class Node {
        private int l, r, sum;
        
        public Node(int _l, int _r, int _sum) {
            this.l = _l;
            this.r = _r;
            this.sum = _sum;
        }
    }
    
    private int[] nums;
    private Node[] segTree;

    public NumArray(int[] nums) {
        int n = nums.length;
        if (n == 0) return;
        this.nums = new int[n + 1];
        this.segTree = new Node[n << 2];
        for (int i = 1; i <= n; ++i) this.nums[i] = nums[i - 1];
        build(1, 1, n);
    }
    
    private void build(int i, int l, int r) {
        segTree[i] = new Node(l, r, 0);
        
        // find the leaf node，assign its sum
        if (l == r) {  
            segTree[i].sum = nums[l];
            return;
        }
        
        // recursively build left and right subtrees
        int mid = (l + r) / 2;
        build(i << 1, l, mid);
        build((i << 1) | 1, mid + 1, r);
        segTree[i].sum = segTree[i << 1].sum + segTree[(i << 1) | 1].sum;
    }
    
    public void update(int i, int val) {
        update(1, i + 1, val);
    }
    
    private int update(int i, int idx, int val) {
        int delta = 0;
        
        // find the leaf node, get the delta and update its sum
        if (segTree[i].l == segTree[i].r) {
            delta = val - segTree[i].sum;
            segTree[i].sum = val;
            return delta;
        }
        
        // recursively go into left or right subtree based on the index of new value
        int mid = (segTree[i].l + segTree[i].r) / 2;
        if (idx <= mid) delta = update(i << 1, idx, val);
        else delta = update((i << 1) | 1, idx, val);
        segTree[i].sum += delta;
        return delta;
    }
    
    public int sumRange(int i, int j) {
        return query(1, i + 1, j + 1);
    }
    
    private int query(int i, int l, int r) {
        int ans = 0;
        
        // find the range, get the sum
        if (segTree[i].l == l && segTree[i].r == r) return segTree[i].sum;
        
        // recursively find left and right bound in the left or right subtree
        int mid = (segTree[i].l + segTree[i].r) / 2;
        if (l > mid) ans = query((i << 1) | 1, l, r);
        else if (r <= mid) ans = query(i << 1, l, r);
        else ans = query(i << 1, l, mid) + query((i << 1) | 1, mid + 1, r);
        return ans;
    }
}




