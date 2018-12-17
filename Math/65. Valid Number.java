
/*

Validate if a given string can be interpreted as a decimal number.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
" -90e3   " => true
" 1e" => false
"e3" => false
" 6e-1" => true
" 99e2.5 " => false
"53.5e93" => true
" --6 " => false
"-+3" => false
"95a54e53" => false

Note: It is intended for the problem statement to be ambiguous. 
You should gather all requirements up front before implementing one. 
However, here is a list of characters that can be in a valid decimal number:

Numbers 0-9
Exponent - "e"
Positive/negative sign - "+"/"-"
Decimal point - "."
Of course, the context of these characters also matters in the input.

*/

/*

O(n),O(1)

*/

public boolean isNumber(String s) {
    if (s == null || s.length() == 0) return false;
    s = s.trim();
    if (s.length() == 0) return false;
    boolean hasNum = false, hasE = false, hasPoint = false;
    int sign = 0;
    for (int i = 0; i < s.length(); ++i) {
        char c = s.charAt(i);
        if ((c < '0' || c > '9') && c != 'e' && c != 'E' && c != '.' && c != '+' && c != '-') return false;
        if ('0' <= c && c <= '9') hasNum = true;
        if (c == 'e' || c == 'E') {
            if (hasE || !hasNum || i == s.length() - 1) return false;
            hasE = true;
        }
        if (c == '.') {
            if (hasPoint || hasE) return false;
            if (i == s.length() - 1 && !hasNum) return false;
            hasPoint = true;
        }
        if (c == '+' || c == '-') {
            if (sign == 2 || i == s.length() - 1) return false;
            if (i > 0 && !hasE) return false;
            sign++;
        }
    }
    return true;
}




