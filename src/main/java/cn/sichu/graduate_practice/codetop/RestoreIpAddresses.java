package cn.sichu.graduate_practice.codetop;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 频率52
 * <p>
 * https://leetcode.cn/problems/restore-ip-addresses/
 * 
 * @author sichu
 * @date 2022/05/19
 */
public class RestoreIpAddresses {
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
            if (judgeIpSegment(s, startIndex, i)) {
                String currentIpSegment = s.substring(startIndex, i + 1);
                path.add(currentIpSegment);
                backtrack(res, path, s, i + 1, residue - 1);
                path.removeLast();
            }
        }
    }

    private static boolean judgeIpSegment(String s, int left, int right) {
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
