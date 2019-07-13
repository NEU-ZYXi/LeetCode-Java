
/*

Given a list of scores of different students, return the average score of each student's top five scores in the order of each student's id.
Each entry items[i] has items[i][0] the student's id, and items[i][1] the student's score.  
The average score is calculated using integer division.

Example 1:
Input: [[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]]
Output: [[1,87],[2,88]]
Explanation: 
The average of the student with id = 1 is 87.
The average of the student with id = 2 is 88.6. But with integer division their average converts to 88.

*/

/*

O(nmlogm),O(nm) where n is number of students and m is number of scores each student has

*/

public int[][] highFive(int[][] items) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int[] item : items) {
        map.putIfAbsent(item[0], new ArrayList<>());
        map.get(item[0]).add(item[1]);
    }
    int[][] ans = new int[map.size()][2];
    for (int id : map.keySet()) {
        List<Integer> scores = map.get(id);
        Collections.sort(scores, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        int sum = 0, avg = 0;
        for (int i = 0; i < Math.min(5, scores.size()); ++i) {
            sum += scores.get(i);
            avg = sum / (i + 1);
        }
        ans[id - 1] = new int[] {id, avg};
    }
    return ans;
}



