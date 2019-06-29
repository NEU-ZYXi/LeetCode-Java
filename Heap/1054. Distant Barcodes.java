
/*

In a warehouse, there is a row of barcodes, where the i-th barcode is barcodes[i].
Rearrange the barcodes so that no two adjacent barcodes are equal.  
You may return any answer, and it is guaranteed an answer exists.

Example 1:
Input: [1,1,1,2,2,2]
Output: [2,1,2,1,2,1]

Example 2:
Input: [1,1,1,1,2,2,3,3]
Output: [1,3,1,3,2,1,2,1]

*/

/*

O(nlogn),O(n)

*/

public int[] rearrangeBarcodes(int[] barcodes) {
    int n = barcodes.length, i = 0;
    int[] ans = new int[n];
    Map<Integer, Integer> map = new HashMap<>();
    PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer a, Integer b) {
            return map.get(b) - map.get(a);
        }
    });
    for (int barcode : barcodes) {
        map.put(barcode, map.getOrDefault(barcode, 0) + 1);
    }
    pq.addAll(map.keySet());
    while (!pq.isEmpty()) {
        int cur = pq.poll(), freq = map.get(cur);
        while (freq-- > 0) {
            if (i >= n) {
                i = 1;
            }
            ans[i] = cur;
            i += 2;
        }
    }
    return ans;
}




