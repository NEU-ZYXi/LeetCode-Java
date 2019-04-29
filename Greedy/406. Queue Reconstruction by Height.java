
/*

Suppose you have a random list of people standing in a queue. 
Each person is described by a pair of integers (h, k), where h is the height of the person and 
k is the number of people in front of this person who have a height greater than or equal to h. 
Write an algorithm to reconstruct the queue.

Example
Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]

*/

/*

O(nlogn),O(n)

*/

public int[][] reconstructQueue(int[][] people) {
    Arrays.sort(people, new Comparator<int[]>() {
        @Override
        public int compare(int[] a, int[] b) {
            return a[0] == b[0] ? a[1] - b[1] : b[0] - a[0];
        }
    });
    List<int[]> ans = new LinkedList<>();
    for (int[] p : people) ans.add(p[1], p);
    return ans.toArray(people);
}




