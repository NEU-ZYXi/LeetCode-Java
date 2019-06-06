
/*

Suppose you have a long flowerbed in which some of the plots are planted and some are not. 
However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.
Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), and a number n, 
return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.

Example 1:
Input: flowerbed = [1,0,0,0,1], n = 1
Output: True

Example 2:
Input: flowerbed = [1,0,0,0,1], n = 2
Output: False

*/

/*

O(n),O(1)

*/

public boolean canPlaceFlowers(int[] flowerbed, int n) {
    if (n > (flowerbed.length + 1) / 2) {
        return false;
    }
    int max = 0, cnt = 0;
    for (int pos : flowerbed) {
        if (pos == 1) {
            max += cnt / 2;
            if (max >= n) {
                return true;
            }
            cnt = -1;
        } else {
            cnt++;
        }
    }
    max += (cnt + 1) / 2;
    if (max >= n) {
        return true;
    }
    return false;
}




