
/*

Given m arrays, and each array is sorted in ascending order. 
Now you can pick up two integers from two different arrays (each array picks one) and calculate the distance. 
We define the distance between two integers a and b to be their absolute difference |a-b|. 
Your task is to find the maximum distance.

Example 1:
Input: 
[[1,2,3],
 [4,5],
 [1,2,3]]
Output: 4
Explanation: 
One way to reach the maximum distance 4 is to pick 1 in the first or third array and pick 5 in the second array.

*/

/*

O(n),O(1)

*/

public int maxDistance(List<List<Integer>> arrays) {
    int ans = 0, max1 = arrays.get(0).get(arrays.get(0).size() - 1), min1 = arrays.get(0).get(0);
    for (int i = 1; i < arrays.size(); ++i) {
        int max2 = arrays.get(i).get(arrays.get(i).size() - 1), min2 = arrays.get(i).get(0);
        ans = Math.max(ans, Math.abs(max1 - min2));
        ans = Math.max(ans, Math.abs(max2 - min1));
        max1 = Math.max(max1, max2);
        min1 = Math.min(min1, min2);
    }
    return ans;
}




