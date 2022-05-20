package cn.sichu.graduate.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author sichu
 * @date 2022/05/20
 */
public class Leetcode0937 {
    public String[] reorderLogFiles(String[] logs) {
        List<String> charLog = new ArrayList<String>();
        List<String> digitLog = new ArrayList<String>();
        for (String log : logs) {
            int i = log.indexOf(' ');
            if (log.charAt(i + 1) >= '0' && log.charAt(i + 1) <= '9') {
                digitLog.add(log);
            } else {
                charLog.add(log);
            }
        }

        charLog.sort((o1, o2) -> {
            String substr1 = o1.substring(o1.indexOf(' ') + 1);
            String substr2 = o2.substring(o2.indexOf(' ') + 1);
            int compare = substr1.compareTo(substr2);
            if (compare == 0) {
                return o1.compareTo(o2);
            } else {
                return compare;
            }
        });
        charLog.addAll(digitLog);
        return charLog.toArray(new String[0]);
    }
}
