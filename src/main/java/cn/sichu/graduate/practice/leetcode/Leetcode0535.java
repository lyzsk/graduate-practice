package cn.sichu.graduate.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sichu
 * @date 2022/06/28
 */
public class Leetcode0535 {
    private Map<Integer, String> map = new HashMap<Integer, String>();
    private int id;

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        ++id;
        map.put(id, longUrl);
        return "http://tinyurl.com/" + id;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int p = shortUrl.lastIndexOf('/') + 1;
        int key = Integer.parseInt(shortUrl.substring(p));
        return map.get(key);
    }
}
