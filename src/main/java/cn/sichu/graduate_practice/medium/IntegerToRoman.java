package cn.sichu.graduate_practice.medium;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/integer-to-roman/
 * 
 * @author sichu
 * @date 2022/04/05
 */
public class IntegerToRoman {
    public String intToRomanSolution1(int num) {
        Map<Integer, String> map = new LinkedHashMap<Integer, String>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

        StringBuilder sb = new StringBuilder("");
        Set<Integer> keys = map.keySet();

        Iterator<Integer> it = keys.iterator();
        while (it.hasNext()) {
            Integer number = it.next();
            while (num >= number.intValue()) {
                num -= number;
                sb.append(map.get(number));
            }
        }

        // for (Integer key : keys) {
        // int tmp = num / key.intValue();
        // while (tmp > 0) {
        // num -= key;
        // sb.append(map.get(key));
        // --tmp;
        // }
        // }
        return sb.toString();
    }

    public String intToRomanSolution2(int num) {
        int[] nums = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder("");

        for (int i = 0; i < nums.length; i++) {
            while (num >= nums[i]) {
                num -= nums[i];
                sb.append(romans[i]);
            }
        }
        return sb.toString();
    }
}
