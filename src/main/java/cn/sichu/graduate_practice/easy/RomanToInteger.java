package cn.sichu.graduate_practice.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/roman-to-integer/
 * 
 * @author sichu
 * @date 2022/03/24
 */
public class RomanToInteger {
    /**
     * O(n)
     * <p>
     * O(1)
     * 
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        Map<Character, Integer> romanTable = new HashMap<Character, Integer>();
        romanTable.put('M', 1000);
        romanTable.put('D', 500);
        romanTable.put('C', 100);
        romanTable.put('L', 50);
        romanTable.put('X', 10);
        romanTable.put('V', 5);
        romanTable.put('I', 1);

        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int value = romanTable.get(s.charAt(i));
            if (i < s.length() - 1 && value < romanTable.get(s.charAt(i + 1))) {
                res -= value;
            } else {
                res += value;
            }
        }

        return res;
    }
}
