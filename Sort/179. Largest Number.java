
/*

Given a list of non negative integers, arrange them such that they form the largest number.

Example 1:
Input: [10,2]
Output: "210"

Example 2:
Input: [3,30,34,5,9]
Output: "9534330"

*/

/*

Solution: sort the array to make A,B in the order of AB>BA, which is A*10^kB+B>B*10^kA+A
          for the next element C, we have BC>CB, which is B*10^kC+C>C*10^kB+B
          to prove AC>CA, which is A*10^kC>C*10^kA+A
          we have A*(C*10^kB+B-C)/B>A*(C*(B*10^kA+A-B)/A+B-C)/B=AC*10^kA+AB-BC>C*10^kA+A, so sorting is correct
O(nlogn),O(n)

*/

public String largestNumber(int[] nums) {
    int n = nums.length;
    if (n == 0) return "";
    String[] strs = new String[n];
    for (int i = 0; i < n; ++i) strs[i] = String.valueOf(nums[i]);
    Arrays.sort(strs, new Comparator<String>() {
        @Override
        public int compare(String a, String b) {
            return (b + a).compareTo(a + b);
        }
    });
    StringBuilder ans = new StringBuilder();
    if (strs[0].equals("0")) return "0";
    for (String str : strs) ans.append(str);
    return ans.toString();
}




