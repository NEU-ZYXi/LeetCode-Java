
/*

Design and implement a TwoSum class. It should support the following operations: add and find.
add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.

Example 1:
add(1); add(3); add(5);
find(4) -> true
find(7) -> false

Example 2:
add(3); add(1); add(2);
find(3) -> true
find(6) -> false

*/

/*

O(n),O(n)

*/

class TwoSum {
    
    private List<Integer> nums;
    private Map<Integer, Integer> map;
    
    /** Initialize your data structure here. */
    public TwoSum() {
        this.nums = new ArrayList<>();
        this.map = new HashMap<>();    
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        nums.add(number);
        map.put(number, map.getOrDefault(number, 0) + 1);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (int i = 0; i < nums.size(); ++i) {
            int num1 = nums.get(i), num2 = value - num1;
            if (num1 == num2 && map.get(num1) > 1) return true;
            if (num1 != num2 && map.containsKey(num2)) return true;
        }
        return false;
    }
}



