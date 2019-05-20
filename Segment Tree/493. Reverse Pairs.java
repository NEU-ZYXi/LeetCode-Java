
/*

Given an array nums, we call (i, j) an important reverse pair if i < j and nums[i] > 2*nums[j].
You need to return the number of important reverse pairs in the given array.

Example1:
Input: [1,3,2,3,1]
Output: 2

Example2:
Input: [2,4,3,5,1]
Output: 3

*/

/*

Solution 1: for each number, get num*2+1 which is smallest to form a reverse pair, use sorted set to discretize all numbers
            use a map to map index of each number
            build the initial segment tree using the static segment tree 
            for each number in the original array, query the segTree[map[num*2+1]...n] to accumulate cnt
            then update segment tree with the current number, which is to update segTree[map[num]]
O(nlogn),O(n)            

*/

class Node {
    private int l, r, cnt;

    public Node(int l, int r, int cnt) {
        this.l = l;
        this.r = r;
        this.cnt = cnt;
    }
}

public int reversePairs(int[] nums) {
    if (nums.length < 2) {
        return 0;
    }
    TreeSet<Long> set = new TreeSet<>();
    for (int num : nums) {
        set.add((long)num);
        set.add((long)num * 2 + 1);
    }
    Node[] segTree = new Node[set.size() << 2];
    Map<Long, Integer> map = new HashMap<>();
    int tot = 0, n = set.size();
    for (Long num : set) {
        map.put(num, tot++);
    }
    build(segTree, 1, 0, n - 1);
    int ans = 0;
    for (int num : nums) {
        int start = map.get((long)num * 2 + 1);
        ans += query(segTree, 1, start, n - 1);
        update(segTree, 1, map.get((long)num));
    }
    return ans;
}

private void build(Node[] segTree, int i, int l, int r) {
    segTree[i] = new Node(l, r, 0);
    if (l == r) {
        return;
    }
    int mid = (l + r) >> 1;
    build(segTree, i << 1, l, mid);
    build(segTree, (i << 1) | 1, mid + 1, r);
}

private void update(Node[] segTree, int i, int idx) {
    if (segTree[i].l == segTree[i].r) {
        segTree[i].cnt++;
        return;
    }
    int mid = (segTree[i].l + segTree[i].r) >> 1;
    if (idx <= mid) {
        update(segTree, i << 1, idx);
    } else {
        update(segTree, (i << 1) | 1, idx);
    }
    segTree[i].cnt = segTree[i << 1].cnt + segTree[(i << 1) | 1].cnt;
}

private int query(Node[] segTree, int i, int l, int r) {
    if (segTree[i].l == l && segTree[i].r == r) {
        return segTree[i].cnt;
    }
    int mid = (segTree[i].l + segTree[i].r) >> 1;
    if (l > mid) {
        return query(segTree, (i << 1) | 1, l, r);
    } else if (r <= mid) {
        return query(segTree, i << 1, l, r);
    } else {
        return query(segTree, i << 1, l, mid) + query(segTree, (i << 1) | 1, mid + 1, r);
    }
}





