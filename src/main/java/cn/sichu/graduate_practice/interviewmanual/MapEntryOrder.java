package cn.sichu.graduate_practice.interviewmanual;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Entry将键值对的对应关系封装成了对象，即键值对对象，这样我们在遍历Map集合时，就可以从每一个键值对（Entry）对象中获取对应的键与对应的值。
 * 
 * @author sichu
 * @date 2022/05/02
 */
public class MapEntryOrder {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("1", 1);
        map.put("2", 2);
        map.put("3", 3);
        map.put("4", 4);
        map.put("5", 5);
        map.put("6", 6);
        map.put("7", 7);
        for (Entry<String, Object> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "::::" + entry.getValue());
        }

        Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
        occurrences.put(1, 3);
        occurrences.put(2, 10);
        occurrences.put(3, 1);
        occurrences.put(4, 100);
        occurrences.put(5, 45);
        occurrences.put(6, 33);
        occurrences.put(7, 9);
        occurrences.put(8, 12);

        List<int[]> values = new ArrayList<int[]>();
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            values.add(new int[] {num, count});
        }
        for (int i = 0; i < values.size(); i++) {
            System.out.println(Arrays.toString(values.get(i)));
        }
    }
}
