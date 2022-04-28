package cn.sichu.graduate_practice.hackerrank;

import java.util.Arrays;

/**
 * https://www.hackerrank.com/test/82cj42i90lk/questions/eestqqps60m
 * 
 * @author sichu
 * @date 2022/04/28
 */
public class HowWillYouCompare {
    /*Write your code here. DO NOT use access modifiers (e.g.: 'public') in your class declarations.*/
    public boolean compare(int a, int b) {
        return Integer.compare(a, b) == 0 ? true : false;
    }

    public boolean compare(String a, String b) {
        return String.valueOf(a) == String.valueOf(b) ? true : false;
    }

    public boolean compare(int[] a, int[] b) {
        return Arrays.equals(a, b) ? true : false;
    }
}
