
/*

Given an arbitrary ransom note string and another string containing letters from all the magazines, 
write a function that will return true if the ransom note can be constructed from the magazines ; 
otherwise, it will return false.
Each letter in the magazine string can only be used once in your ransom note.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true

*/

/*

O(n+m),O(1)

*/

public boolean canConstruct(String ransomNote, String magazine) {
    int[] buckets = new int[26];
    for (char c : magazine.toCharArray()) buckets[c - 'a']++;
    for (char c : ransomNote.toCharArray()) {
        if (buckets[c - 'a'] <= 0) return false;
        buckets[c - 'a']--;
    }
    return true;
}



