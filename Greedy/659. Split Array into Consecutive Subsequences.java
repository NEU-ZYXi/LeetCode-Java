
/*

Given an array nums sorted in ascending order, 
return true if and only if you can split it into 1 or more subsequences 
such that each subsequence consists of consecutive integers and has length at least 3.

Example 1:
Input: [1,2,3,3,4,5]
Output: True
Explanation:
You can split them into two consecutive subsequences : 
1, 2, 3
3, 4, 5

Example 2:
Input: [1,2,3,3,4,4,5,5]
Output: True
Explanation:
You can split them into two consecutive subsequences : 
1, 2, 3, 4, 5
3, 4, 5

Example 3:
Input: [1,2,3,4,4,5]
Output: False

*/

/*

Solution: use a tail hashmap to track the current tails of each subsequence
          whenever we have a non-tail element, trigger a new subsequence
          whenever we have a tail element, greedily append next element and let next element a new tail
O(n),O(n)          

*/

public boolean isPossible(int[] nums) {
    Map<Integer, Integer> buckets = new HashMap<>();
    Map<Integer, Integer> tails = new HashMap<>();
    for (int num : nums) {
        buckets.put(num, buckets.getOrDefault(num, 0) + 1);
    }
    for (int num : nums) {
        if (buckets.get(num) > 0) {
            if (tails.getOrDefault(num, 0) > 0) {
                tails.put(num, tails.get(num) - 1);
                tails.put(num + 1, tails.getOrDefault(num + 1, 0) + 1);
            } else if (buckets.getOrDefault(num + 1, 0) > 0 && buckets.getOrDefault(num + 2, 0) > 0) {
                buckets.put(num + 1, buckets.get(num + 1) - 1);
                buckets.put(num + 2, buckets.get(num + 2) - 1);
                tails.put(num + 3, tails.getOrDefault(num + 3, 0) + 1);
            } else {
                return false;
            }
            buckets.put(num, buckets.get(num) - 1);
        }
    }
    return true;
}




