
/*

Design and implement a data structure for a compressed string iterator. 
It should support the following operations: next and hasNext.
The given compressed string will be in the form of each letter followed by a positive integer 
representing the number of this letter existing in the original uncompressed string.
next() - if the original string still has uncompressed characters, return the next letter; Otherwise return a white space.
hasNext() - Judge whether there is any letter needs to be uncompressed.
Note:
Please remember to RESET your class variables declared in StringIterator, 
as static/class variables are persisted across multiple test cases. 
Please see here for more details.

Example:
StringIterator iterator = new StringIterator("L1e2t1C1o1d1e1");
iterator.next(); // return 'L'
iterator.next(); // return 'e'
iterator.next(); // return 'e'
iterator.next(); // return 't'
iterator.next(); // return 'C'
iterator.next(); // return 'o'
iterator.next(); // return 'd'
iterator.hasNext(); // return true
iterator.next(); // return 'e'
iterator.hasNext(); // return false
iterator.next(); // return ' '

*/

/*

O(n),O(n)

*/

class StringIterator {
    private char[] chars;
    private char c;
    private int i;
    private int cnt;

    public StringIterator(String compressedString) {
        this.chars = compressedString.toCharArray();
    }
    
    public char next() {
        if (cnt > 0) {
            cnt--;
            return c;
        } else if (i < chars.length) {
            c = chars[i];
            int j = i + 1;
            while (j < chars.length && Character.isDigit(chars[j])) {
                cnt = cnt * 10 + (chars[j] - '0');
                j++;
            }
            cnt--;
            i = j;
            return c;
        } else {
            return ' ';
        }
    }
    
    public boolean hasNext() {
        return cnt > 0 || i < chars.length;
    }
}




