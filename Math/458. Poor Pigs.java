
/*

There are 1000 buckets, one and only one of them is poisonous, while the rest are filled with water. 
They all look identical. If a pig drinks the poison it will die within 15 minutes. 
What is the minimum amount of pigs you need to figure out which bucket is poisonous within one hour?
Answer this question, and write an algorithm for the general case.

General case:
If there are n buckets and a pig drinking poison will die within m minutes, 
how many pigs (x) you need to figure out the poisonous bucket within p minutes? There is exactly one bucket with poison.

*/

/*

O(1),O(1)

*/

public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
    int attemps = minutesToTest / minutesToDie + 1;
    int ans = 0;
    while (Math.pow(attemps, ans) < buckets) ans++;
    return ans;
}




