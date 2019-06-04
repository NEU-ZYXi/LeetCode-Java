
/*

Suppose Andy and Doris want to choose a restaurant for dinner, 
and they both have a list of favorite restaurants represented by strings.
You need to help them find out their common interest with the least list index sum. 
If there is a choice tie between answers, output all of them with no order requirement. 
You could assume there always exists an answer.

Example 1:
Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
Output: ["Shogun"]
Explanation: The only restaurant they both like is "Shogun".

Example 2:
Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["KFC", "Shogun", "Burger King"]
Output: ["Shogun"]
Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).

*/

/*

O(n),O(n)

*/

public String[] findRestaurant(String[] list1, String[] list2) {
    List<String> ans = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < list1.length; ++i) {
        map.put(list1[i], i);
    }
    for (int i = 0; i < list2.length; ++i) {
        if (map.containsKey(list2[i])) {
            int sum = i + map.get(list2[i]);
            if (sum < min) {
                min = sum;
                ans = new ArrayList<>();
                ans.add(list2[i]);
            } else if (sum == min) {
                ans.add(list2[i]);
            }
        }
    }
    return ans.toArray(new String[0]);
}



