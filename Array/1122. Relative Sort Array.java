
/*

Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2. 
Elements that don't appear in arr2 should be placed at the end of arr1 in ascending order. 

Example 1:
Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
Output: [2,2,2,1,4,3,3,9,6,7,19]

*/

/*

O(nlogn),O(n)

*/

public int[] relativeSortArray(int[] arr1, int[] arr2) {
    int[] ans = new int[arr1.length];
    int i = 0;
    TreeMap<Integer, Integer> map = new TreeMap<>();
    for (int a : arr1) {
        map.put(a, map.getOrDefault(a, 0) + 1);
    }
    for (int a : arr2) {
        if (map.containsKey(a)) {
            for (int j = 0; j < map.get(a); ++j) {
                ans[i++] = a;
            }
            map.remove(a);
        }
    }
    for (int num : map.keySet()) {
        for (int j = 0; j < map.get(num); ++j) {
            ans[i++] = num;
        }
    }
    return ans;
}



