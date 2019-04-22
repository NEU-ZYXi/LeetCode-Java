
/*

Design a data structure that supports all following operations in average O(1) time.
Note: Duplicate elements are allowed.
insert(val): Inserts an item val to the collection.
remove(val): Removes an item val from the collection if present.
getRandom: Returns a random element from current collection of elements. 
The probability of each element being returned is linearly related to the number of same value the collection contains.

Example:
// Init an empty collection.
RandomizedCollection collection = new RandomizedCollection();

// Inserts 1 to the collection. Returns true as the collection did not contain 1.
collection.insert(1);

// Inserts another 1 to the collection. Returns false as the collection contained 1. Collection now contains [1,1].
collection.insert(1);

// Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
collection.insert(2);

// getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3.
collection.getRandom();

// Removes 1 from the collection, returns true. Collection now contains [1,2].
collection.remove(1);

// getRandom should return 1 and 2 both equally likely.
collection.getRandom();

*/

/*

O(1),O(n)

*/

class RandomizedCollection {
    
    private List<Integer> nums;
    private Map<Integer, Set<Integer>> map;
    private Random rand;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        this.nums = new ArrayList<>();
        this.map = new HashMap<>();
        this.rand = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean ans = false;
        if (!map.containsKey(val)) {
            ans = true;
            map.put(val, new HashSet<>());
        }
        map.get(val).add(nums.size());
        nums.add(val);
        return ans;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int idx = map.get(val).iterator().next();
        map.get(val).remove(idx);
        if (idx < nums.size() - 1) {
            int last = nums.get(nums.size() - 1);
            nums.set(idx, last);
            map.get(last).remove(nums.size() - 1);
            map.get(last).add(idx);
        }
        nums.remove(nums.size() - 1);
        if (map.get(val).isEmpty()) map.remove(val);
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}




