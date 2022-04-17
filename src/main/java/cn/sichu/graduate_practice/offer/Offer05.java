package cn.sichu.graduate_practice.offer;

/**
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 * 
 * @author sichu
 * @date 2022/04/17
 */
public class Offer05 {
    public String replaceSpace(String s) {
        char[] arr = new char[s.length() * 3];
        int size = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                arr[size++] = '%';
                arr[size++] = '2';
                arr[size++] = '0';
            } else {
                arr[size++] = ch;
            }
        }
        String str = new String(arr, 0, size);
        return str;
    }
}
