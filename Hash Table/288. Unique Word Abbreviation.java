
/*

An abbreviation of a word follows the form <first letter><number><last letter>. 
Below are some examples of word abbreviations:
a) it                      --> it    (no abbreviation)

     1
     ↓
b) d|o|g                   --> d1g

              1    1  1
     1---5----0----5--8
     ↓   ↓    ↓    ↓  ↓    
c) i|nternationalizatio|n  --> i18n

              1
     1---5----0
     ↓   ↓    ↓
d) l|ocalizatio|n          --> l10n
Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. 
A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.

Example:
Given dictionary = [ "deer", "door", "cake", "card" ]
isUnique("dear") -> false
isUnique("cart") -> true
isUnique("cane") -> false
isUnique("make") -> true

*/

/*

O(n),O(n)

*/

class ValidWordAbbr {
    
    private Map<String, String> map;

    public ValidWordAbbr(String[] dictionary) {
        this.map = new HashMap<>();
        for (String s : dictionary) {
            String abbr = getAbbr(s);
            if (map.containsKey(abbr)) {
                if (!map.get(abbr).equals(s)) map.put(abbr, "#");
            } else map.put(abbr, s);
        }
    }
    
    public boolean isUnique(String word) {
        String abbr = getAbbr(word);
        return !map.containsKey(abbr) || map.get(abbr).equals(word);
    }
    
    private String getAbbr(String s) {
        if (s.length() <= 2) return s;
        return "" + s.charAt(0) + (s.length() - 2) + s.charAt(s.length() - 1);
    }
}




