
/*

TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl 
and it returns a short URL such as http://tinyurl.com/4e9iAk.
Design the encode and decode methods for the TinyURL service. 
There is no restriction on how your encode/decode algorithm should work. 
You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.

*/

/*

O(1),O(1)

*/

public class Codec {
    private String host = "http://tinyurl.com/";
    private Map<Integer, String> map = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        int hash = longUrl.hashCode();
        map.put(hash, longUrl);
        return host + hash;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(Integer.valueOf(shortUrl.replace(host, "")));
    }
}


public class Codec {
    private String host = "http://tinyurl.com/";
    private Map<String, String> map = new HashMap<>();
    private String seed = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String key = "";
        do {
            String s = "";
            for (int i = 0; i < 6; i++) {
                int rand = (int)(Math.random() * seed.length());
                s += seed.charAt(rand);
            }
            key = s;
        } while (map.containsKey(key));
        map.put(key, longUrl);
        return host + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl.replace(host, ""));
    }
}





