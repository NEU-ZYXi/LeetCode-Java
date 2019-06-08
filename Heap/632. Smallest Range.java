
/*

You have k lists of sorted integers in ascending order. 
Find the smallest range that includes at least one number from each of the k lists.
We define the range [a,b] is smaller than range [c,d] if b-a < d-c or a < c if b-a == d-c.

Example 1:
Input:[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
Output: [20,24]
Explanation: 
List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
List 2: [0, 9, 12, 20], 20 is in range [20,24].
List 3: [5, 18, 22, 30], 22 is in range [20,24].

*/

/*

Solution: create a custom class for each number and its index
          use a priority queue to store numbers from each list
          find the max and min number in current priority queue and update smallest range
          move min number index in its list to check for next number
O(nmlogn),O(n) where n is length of nums and m is length of each list in nums        

*/

class Tuple {
    private int num, listIdx, idx;

    public Tuple(int num, int listIdx, int idx) {
        this.num = num;
        this.listIdx = listIdx;
        this.idx = idx;
    }
}

public int[] smallestRange(List<List<Integer>> nums) {
    PriorityQueue<Tuple> pq = new PriorityQueue<>(new Comparator<Tuple>() {
        @Override
        public int compare(Tuple a, Tuple b) {
            return a.num - b.num;
        }
    });
    int max = Integer.MIN_VALUE, start = 0, end = 0, range = Integer.MAX_VALUE;
    for (int i = 0; i < nums.size(); ++i) {
        pq.offer(new Tuple(nums.get(i).get(0), i, 0));
        max = Math.max(max, nums.get(i).get(0));
    }
    while (pq.size() == nums.size()) {
        Tuple cur = pq.poll();
        if (max - cur.num < range) {
            range = max - cur.num;
            start = cur.num;
            end = max;
        }
        if (cur.idx + 1 < nums.get(cur.listIdx).size()) {
            cur.idx++;
            cur.num = nums.get(cur.listIdx).get(cur.idx);
            pq.offer(cur);
            max = Math.max(max, cur.num);
        }
    }
    return new int[] {start, end};
}




