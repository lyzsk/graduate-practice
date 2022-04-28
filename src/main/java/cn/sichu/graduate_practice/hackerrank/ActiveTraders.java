package cn.sichu.graduate_practice.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * https://www.hackerrank.com/test/33gp893pqhs/questions/8dhrrgdc9fa
 * 
 * @author sichu
 * @date 2022/04/28
 */
public class ActiveTraders {
    public static List<String> mostActive(List<String> customers) {
        // Write your code here
        Map<String, Integer> map = new TreeMap<String, Integer>();
        List<String> res = new ArrayList<String>();
        int size = customers.size();

        for (int i = 0; i < size; i++) {
            if (map.containsKey(customers.get(i))) {
                int count = map.get(customers.get(i));
                map.put(customers.get(i), ++count);
            } else {
                map.put(customers.get(i), 1);
            }
        }
        Set<String> set = map.keySet();
        for (String key : set) {
            int customerCount = map.get(key);
            double percent = (double)customerCount / (double)size;
            if (percent >= 0.05) {
                res.add(key);
            }
        }
        return res;
    }
}
