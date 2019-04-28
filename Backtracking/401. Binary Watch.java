
/*

A binary watch has 4 LEDs on the top which represent the hours (0-11), 
and the 6 LEDs on the bottom represent the minutes (0-59).
Each LED represents a zero or one, with the least significant bit on the right.
Given a non-negative integer n which represents the number of LEDs that are currently on, 
return all possible times the watch could represent.

Example:
Input: n = 1
Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]

*/

/*

O(5^n),O(5^n)

*/

public List<String> readBinaryWatch(int num) {
    List<String> ans = new ArrayList<>();
    int[] hour = new int[] {8, 4, 2, 1}, minute = new int[] {32, 16, 8, 4, 2, 1};
    for (int i = 0; i <= num; ++i) {
        List<Integer> hours = get(hour, i);
        List<Integer> minutes = get(minute, num - i);
        for (int h : hours) {
            if (h >= 12) continue;
            for (int m : minutes) {
                if (m >= 60) continue;
                ans.add(h + ":" + (m < 10 ? "0" + m : m));
            }
        }
    }
    return ans;
}

private List<Integer> get(int[] nums, int cnt) {
    List<Integer> ans = new ArrayList<>();
    dfs(ans, nums, cnt, 0, 0);
    return ans;
}

private void dfs(List<Integer> ans, int[] nums, int cnt, int idx, int sum) {
    if (cnt == 0) {
        ans.add(sum);
        return;
    }
    for (int i = idx; i < nums.length; ++i) {
        dfs(ans, nums, cnt - 1, i + 1, sum + nums[i]);
    }
}




