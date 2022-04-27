package cn.sichu.graduate_practice.interviewmanual;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 遍历ArrayList时如何正确移除一个元素
 * <p>
 * 该问题的关键在于面试者使用的是 ArrayList 的 remove() 还是 Iterator 的 remove()方法。
 * 
 * @author sichu
 * @date 2022/04/27
 */
public class RemoveInArrayList {

    public static void main(String[] args) {
        java.util.logging.Logger logger = java.util.logging.Logger.getLogger("LoggingDemo");

        ArrayList<String> alist = new ArrayList<String>();
        alist.add("a");
        alist.add("ab");
        alist.add("abc");
        alist.add("abcd");
        alist.add("abc");

        useRemove(alist);
        // useIterator(alist);
        System.out.println(alist); // 结果可能一样，但是如果遇到blist的情况，remove不能正确删除

        ArrayList<String> blist = new ArrayList<String>();
        blist.add("a");
        blist.add("ab");
        blist.add("abc");
        blist.add("abc");
        blist.add("abc");
        // useRemove(blist); // 用这个不能得到正确结果
        useIterator(blist);
        System.out.println(blist);
    }

    private static ArrayList<String> useRemove(ArrayList<String> input) {
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i).equals("abc")) {
                input.remove(i);
            }
        }
        return input;
    }

    private static ArrayList<String> useIterator(ArrayList<String> input) {
        Iterator<String> iter = input.iterator();
        while (iter.hasNext()) {
            if (iter.next().equals("abc")) {
                iter.remove();
            }
        }
        return input;
    }

}
