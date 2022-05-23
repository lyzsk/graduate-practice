package cn.sichu.graduate.practice.leetcode.offer;

/**
 * 
 * @author sichu
 * @date 2022/05/22
 */
public class Offer05 {
    public String replaceSpace(String s) {
        char[] arr = new char[s.length() * 3];
        int size = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                arr[size] = '%';
                ++size;
                arr[size] = '2';
                ++size;
                arr[size] = '0';
                ++size;
            } else {
                arr[size] = ch;
                ++size;
            }
        }
        String res = new String(arr, 0, size);
        return res;
    }
}
