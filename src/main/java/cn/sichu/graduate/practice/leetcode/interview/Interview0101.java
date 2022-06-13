package cn.sichu.graduate.practice.leetcode.interview;

import java.util.HashSet;
import java.util.Set;

/**
 * @author sichu
 * @date 2022/06/13
 */
public class Interview0101 {
    public boolean isUnique(String astr) {
        Set<Character> set = new HashSet<Character>();
        for (int i = 0; i < astr.length(); i++) {
            if (!set.add(astr.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
