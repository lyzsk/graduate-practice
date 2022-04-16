package cn.sichu.graduate_practice.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/repeated-dna-sequences/
 * 
 * @author sichu
 * @date 2022/04/16
 */
public class RepeatedDnaSequences {

    /**
     * O(NL)
     * <p>
     * O(n)
     * 
     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequencesSolution1(String s) {
        List<String> res = new ArrayList<String>();
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i + 10 <= s.length(); i++) {
            String sub = s.substring(i, i + 10);
            int count = map.getOrDefault(sub, 0);
            if (count == 1) {
                res.add(sub);
            }
            map.put(sub, count + 1);
        }
        return res;
    }

    /**
     * O(n)???
     * <p>
     * O(n)
     * 
     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequencesSolution2(String s) {
        Map<Character, Integer> ch = new HashMap<Character, Integer>();
        ch.put('A', 0);
        ch.put('C', 1);
        ch.put('G', 2);
        ch.put('T', 3);
        List<String> res = new ArrayList<String>();
        if (s.length() <= 10) {
            return res;
        }
        int x = 0;
        for (int i = 0; i < 10 - 1; i++) {
            // 窗口右移一位，由于每个字母用2bit，所以<<2，，一个新字符进入窗口
            x = (x << 2) | ch.get(s.charAt(i));
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i <= s.length() - 10; i++) {
            // 窗口最左边字符离开窗口，由于只考虑x的前20bit，所以其他位置要补零: x = x & ((1 << 20) - 1)
            x = ((x << 2) | ch.get(s.charAt(i + 10 - 1))) & ((1 << 20) - 1);
            map.put(x, map.getOrDefault(x, 0) + 1);
            if (map.get(x) == 2) {
                res.add(s.substring(i, i + 10));
            }
        }
        return res;
    }
}
