package cn.sichu.graduate.practice.leetcode.interview;

/**
 * @author sichu
 * @date 2022/06/13
 */
public class Interview0103 {
    public String replaceSpaces(String S, int length) {
        if (S == null || S.length() == 0) {
            return S;
        }
        char[] arr = S.toCharArray();
        int index = arr.length - 1;
        for (int i = length - 1; i >= 0; i--) {
            if (arr[i] == ' ') {
                arr[index] = '0';
                --index;
                arr[index] = '2';
                --index;
                arr[index] = '%';
                --index;
            } else {
                arr[index] = arr[i];
                --index;
            }
        }
        return new String(arr, index + 1, arr.length - index - 1);
    }
}
