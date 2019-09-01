
/*

Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits.
There is no limit on how many times a digit can be reused.
You may assume the given input string is always valid. 
For example, "01:34", "12:09" are all valid. "1:34", "12:9" are all invalid.

Example 1:
Input: "19:34"
Output: "19:39"
Explanation: The next closest time choosing from digits 1, 9, 3, 4, is 19:39, which occurs 5 minutes later. 
It is not 19:33, because this occurs 23 hours and 59 minutes later.

Example 2:
Input: "23:59"
Output: "22:22"
Explanation: The next closest time choosing from digits 2, 3, 5, 9, is 22:22. 
It may be assumed that the returned time is next day's time since it is smaller than the input time numerically.

*/

/*

O(1),O(1)

*/

public String nextClosestTime(String time) {
    char[] digits = time.toCharArray();
    TreeSet<Character> set = new TreeSet<>();
    for (char c : digits) {
        if (c != ':') {
            set.add(c);
        }
    }
    digits[4] = getNext(digits[4], '9', set);
    if (digits[4] > time.charAt(4)) {
        return String.valueOf(digits);
    }
    digits[3] = getNext(digits[3], '5', set);
    if (digits[3] > time.charAt(3)) {
        return String.valueOf(digits);
    }
    digits[1] = getNext(digits[1], digits[0] < '2' ? '9' : '3', set);
    if (digits[1] > time.charAt(1)) {
        return String.valueOf(digits);
    }
    digits[0] = getNext(digits[0], '2', set);
    return String.valueOf(digits);
}

private char getNext(char c, char limit, TreeSet<Character> set) {
    Character next = set.higher(c);
    next = (next == null || next > limit ? set.first() : next);
    return next;
}




