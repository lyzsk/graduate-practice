package cn.sichu.graduate_practice.hard;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.cn/problems/tag-validator/
 * 
 * @author sichu
 * @date 2022/05/20
 */
public class TagValidator {
    public boolean isValid(String code) {
        int n = code.length();
        Deque<String> tags = new ArrayDeque<String>();
        int i = 0;
        while (i < n) {
            if (code.charAt(i) == '<') {
                if (i == n - 1) {
                    return false;
                }
                // 遇到结束tag
                if (code.charAt(i + 1) == '/') {
                    int j = code.indexOf('>', i);
                    if (j < 0) {
                        return false;
                    }
                    String tagname = code.substring(i + 2, j);
                    if (tags.isEmpty() || !tags.peekFirst().equals(tagname)) {
                        return false;
                    }
                    tags.removeFirst();
                    // 移动 i 到 > 后一位
                    i = j + 1;
                    if (tags.isEmpty() && i != n) {
                        return false;
                    }
                } else if (code.charAt(i + 1) == '!') {
                    // 遇到 cdata 标签
                    if (tags.isEmpty()) {
                        return false;
                    }
                    // cdata 前缀 <![CDATA[
                    if (i + 9 > n) {
                        return false;
                    }
                    String cdata = code.substring(i + 2, i + 9);
                    if (!"[CDATA[".equals(cdata)) {
                        return false;
                    }
                    // cdata 后缀 ]]>
                    int j = code.indexOf("]]>", i);
                    if (j < 0) {
                        return false;
                    }
                    i = j + 3;
                } else {
                    // 否则情况: < 的下一位既不是/，也不是!，则是标签头
                    int j = code.indexOf('>', i);
                    if (j < 0) {
                        return false;
                    }
                    String tagname = code.substring(i + 1, j);
                    if (tagname.length() < 1 || tagname.length() > 9) {
                        return false;
                    }
                    for (int k = 0; k < tagname.length(); k++) {
                        if (!Character.isUpperCase(tagname.charAt(k))) {
                            return false;
                        }
                    }
                    tags.addFirst(tagname);
                    i = j + 1;
                }
            } else {
                if (tags.isEmpty()) {
                    return false;
                }
                ++i;
            }
        }
        return tags.isEmpty();
    }
}
