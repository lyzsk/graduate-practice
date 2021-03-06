package cn.sichu.graduate.practice.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 类似的题： Leetcode0046， Leetcode0047, Leetcode0039, Leetcode0040, <b>Leetcode0077</b>, Leetcode0078, Leetcode0090,
 * <b>Leetcode0060</b>, Leetcode0093, Leetcode0733, Leetcode0200, Leetcode0130, Leetcode0079, Leetcode0017,
 * <b>Leetcode0784</b>, Leetcode0022, Leetcode0051, Leetcode0037, Leetcode0488, Leetcode0529
 * 
 * @author sichu
 * @date 2022/05/28
 */
public class Leetcode0093 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        if (s.length() < 4 || s.length() > 12) {
            return res;
        }
        Deque<String> path = new ArrayDeque<String>();
        backtrack(res, path, s, 0, 4);
        return res;
    }

    private static void backtrack(List<String> res, Deque<String> path, String s, int startIndex, int residue) {
        if (startIndex == s.length()) {
            if (residue == 0) {
                res.add(String.join(".", path));
            }
            return;
        }
        for (int i = startIndex; i < startIndex + 3; i++) {
            if (i >= s.length()) {
                break;
            }
            if (isIPSegment(s, startIndex, i)) {
                String currentIPSegment = s.substring(startIndex, i + 1);
                path.add(currentIPSegment);
                backtrack(res, path, s, i + 1, residue - 1);
                path.removeLast();
            }
        }
    }

    private static boolean isIPSegment(String s, int left, int right) {
        int len = right - left + 1;
        if (len > 1 && s.charAt(left) == '0') {
            return false;
        }
        int res = 0;
        while (left <= right) {
            res = res * 10 + s.charAt(left) - '0';
            ++left;
        }
        return res >= 0 && res <= 255;
    }
}
