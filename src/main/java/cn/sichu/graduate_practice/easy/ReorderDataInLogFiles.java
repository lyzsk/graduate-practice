package cn.sichu.graduate_practice.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/reorder-data-in-log-files/
 * 
 * @author sichu
 * @date 2022/05/03
 */
public class ReorderDataInLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        List<String> alphaLog = new ArrayList<String>();
        List<String> digitLog = new ArrayList<String>();

        for (String log : logs) {
            char ch = log.charAt(log.length() - 1);
            boolean isNum = Character.isDigit(ch);
            if (isNum) {
                digitLog.add(log);
            } else {
                alphaLog.add(log);
            }
        }

        Collections.sort(alphaLog, (o1, o2) -> {
            String s1 = o1.substring(o1.indexOf(' ') + 1);
            String s2 = o2.substring(o2.indexOf(' ') + 1);
            if (s1.equals(s2)) {
                return o1.compareTo(o2);
            } else {
                return s1.compareTo(s2);
            }
        });

        alphaLog.addAll(digitLog);
        return alphaLog.toArray(new String[0]);
    }
}
