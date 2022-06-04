package cn.sichu.graduate.practice.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author sichu
 * @date 2022/06/03
 */
public class Leetcode0929 {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<String>();
        for (String email : emails) {
            int idx = email.indexOf("@");
            String local = email.substring(0, idx).split("\\+")[0].replace(".", "");
            set.add(local + email.substring(idx));
        }
        return set.size();
    }
}
