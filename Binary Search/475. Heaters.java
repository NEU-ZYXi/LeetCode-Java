
/*

Winter is coming! Your first job during the contest is to design a standard heater with fixed warm radius to warm all the houses.
Now, you are given positions of houses and heaters on a horizontal line, 
find out minimum radius of heaters so that all houses could be covered by those heaters.
So, your input will be the positions of houses and heaters seperately, 
and your expected output will be the minimum radius standard of heaters.
 
Example 1:
Input: [1,2,3],[2]
Output: 1
Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard, 
then all the houses can be warmed.
 
Example 2:
Input: [1,2,3,4],[1,4]
Output: 1
Explanation: The two heater was placed in the position 1 and 4. We need to use radius 1 standard, 
then all the houses can be warmed.

*/

/*

Solution 1: for each house, find the left and right heater, compare to find the minimum radius
O(nlogm+mlogm),O(1) where n is the length of houses and m is the length of heaters

*/

public int findRadius(int[] houses, int[] heaters) {
    int ans = 0, n = heaters.length;
    Arrays.sort(heaters);
    for (int house : houses) {
        int l = 0, r = n - 1, heater = 0, samePosition = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (heaters[mid] == house) {
                samePosition = 1;
                break;
            } else if (heaters[mid] > house) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if (samePosition == 1) {
            continue;
        } else {
            heater = l;
        }
        int left = heater > 0 ? house - heaters[heater - 1] : Integer.MAX_VALUE;
        int right = heater < n ? heaters[heater] - house : Integer.MAX_VALUE;
        ans = Math.max(ans, Math.min(left, right));
    }
    return ans;
}


/*

Solution 2: sort houses and heaters, for each house, find the closest heater either left or right, compare to find the maximum
O(nlogn+mlogm),O(1)

*/

public int findRadius(int[] houses, int[] heaters) {
    int ans = 0, i = 0;
    Arrays.sort(houses);
    Arrays.sort(heaters);
    for (int house : houses) {
        while (i < heaters.length - 1 && Math.abs(house - heaters[i]) >= Math.abs(house - heaters[i + 1])) {
            i++;
        }
        ans = Math.max(ans, Math.abs(house - heaters[i]));
    }
    return ans;
}




