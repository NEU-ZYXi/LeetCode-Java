
/*

You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
Define a pair (u,v) which consists of one element from the first array and one element from the second array.
Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

Example 1:
Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
Output: [[1,2],[1,4],[1,6]] 
Explanation: The first 3 pairs are returned from the sequence: 
             [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
             
Example 2:
Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
Output: [1,1],[1,1]
Explanation: The first 2 pairs are returned from the sequence: 
             [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
             
Example 3:
Input: nums1 = [1,2], nums2 = [3], k = 3
Output: [1,3],[2,3]
Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]

*/

/*

O(klogn),O(n)

*/

class Tuple implements Comparable<Tuple> {
    private int i, j, val;

    public Tuple(int i, int j, int val) {
        this.i = i;
        this.j = j;
        this.val = val;
    }

    public int compareTo(Tuple t) {
        return this.val - t.val;
    }
}

public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    List<int[]> ans = new ArrayList<>();
    if (nums1.length == 0 || nums2.length == 0) return ans;
    PriorityQueue<Tuple> pq = new PriorityQueue<>();
    for (int i = 0; i < nums1.length; ++i) {
        pq.offer(new Tuple(i, 0, nums1[i] + nums2[0]));
    }
    while (k-- > 0 && !pq.isEmpty()) {
        Tuple cur = pq.poll();
        ans.add(new int[] {nums1[cur.i], nums2[cur.j]});
        if (cur.j + 1 < nums2.length) pq.offer(new Tuple(cur.i, cur.j + 1, nums1[cur.i] + nums2[cur.j + 1]));
    }
    return ans;
}




