package cn.sichu.graduate.practice.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 字节面试题: 数组A中给定可以使用的1~9的数，返回由A数组中的元素组成的小于n的最大数。例如A={1, 2, 4, 9}，n=2533，返回2499
 * 
 * @author sichu
 * @date 2022/05/24
 */
public class Test0001 {
    public static int returnMax(int[] A, int n) {
        if (A == null || A.length == 0) {
            return -1;
        }
        char[] arr = (n + "").toCharArray();
        int[] resIdx = new int[arr.length];
        boolean flag = false;
        int i, j;
        for (i = 0; i < arr.length; i++) {
            int ch = arr[i] - '0';
            for (j = A.length - 1; j >= 0; j--) {
                if (flag) {
                    resIdx[i] = j;
                    break;
                } else if (ch == A[j]) {
                    resIdx[i] = j;
                    break;
                } else if (ch > A[j]) {
                    resIdx[i] = j;
                    flag = true;
                    break;
                }
            }
            if (j == -1) {
                if (i == 0) {
                    resIdx[i] = -1;
                } else {
                    int pre = i;
                    while (pre > 0 && resIdx[pre] == 0) {
                        resIdx[pre] = A.length - 1;
                        --pre;
                    }
                    --resIdx[pre];
                }
                flag = true;
            }
        }
        int res = 0;
        int index = resIdx[0] == -1 ? 1 : 0;
        while (index < arr.length) {
            res = res * 10 + A[resIdx[index]];
            ++index;
        }
        if (res == n) {
            int m = resIdx.length - 1;
            while (m >= 0 && resIdx[m] == 0) {
                --m;
            }
            --resIdx[m];
            index = resIdx[0] == -1 ? 1 : 0;
            res = 0;
            while (index < arr.length) {
                res = res * 10 + A[resIdx[index]];
                ++index;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 4, 9};
        int n = 2533;
        int res = returnMax(A, n);
        System.out.print(res);
        // int a = 1;
        // int b = 0;
        // int c = a / b;
        // System.out.print(c);

        List<String> list = new ArrayList<String>(Arrays.asList("a", "b", "c"));
        for (String value : list) {
            if (value.equals("a")) {
                list.remove(value);
            }
        }
        System.out.println(list);
    }
}
