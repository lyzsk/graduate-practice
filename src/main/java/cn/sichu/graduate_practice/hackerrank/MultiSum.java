package cn.sichu.graduate_practice.hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/test/82cj42i90lk/questions/96dq17oi0cc
 * 
 * @author sichu
 * @date 2022/04/28
 */
public class MultiSum {
    public static void main(String args[]) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner scan = new Scanner(System.in);
        Object[] objs = scan.nextLine().split(" ");

        int sum = 0;
        int i = 0;
        for (Object obj : objs) {
            if (obj instanceof String) {
                String str = (String)obj;
                System.out.print(str);
            } else if (obj instanceof Integer) {
                int digit = (Integer)obj;
                sum += digit;
                if (i == objs.length) {
                    System.out.print(sum);
                }
                ++i;
            }
        }
    }
}
