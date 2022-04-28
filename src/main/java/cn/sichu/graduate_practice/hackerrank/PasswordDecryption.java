package cn.sichu.graduate_practice.hackerrank;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://www.hackerrank.com/test/33gp893pqhs/questions/bdfkfnld4gp
 * <p>
 * "43Ah*ck0rr0nk" -> "hAck3rr4nk"
 * <p>
 * "51Pa*0Lp*0e" -> "aP1pL5e"
 * <p>
 * original digit 1-9, no "0"
 * <p>
 * 
 * @author sichu
 * @date 2022/04/28
 */
public class PasswordDecryption {
    public static void main(String[] args) {
        // "43Ah*ck0rr0nk" -> "hAck3rr4nk"
        System.out.println("43Ah*ck0rr0nk -> " + decryptPassword("43Ah*ck0rr0nk"));
        // "51Pa*0Lp*0e" -> "aP1pL5e"
        System.out.println("51Pa*0Lp*0e -> " + decryptPassword("51Pa*0Lp*0e"));
        // "443Ah*ck0rr0nk" -> "3hAck4rr4nk"
        System.out.println("443Ah*ck0rr0nk -> " + decryptPassword("443Ah*ck0rr0nk"));
        // "4343Ah*ck0r0r0n0k" -> "hAck3r4r3n4k"
        System.out.println("4343Ah*ck0r0r0n0k -> " + decryptPassword("4343Ah*ck0r0r0n0k"));
        // "44351PaPaPa*Ah*ck0r0r0nk0" -> "1PaPaaPhAck5r3r4nk4"
        System.out.println("44351PaPaPa*Ah*ck0r0r0nk0 -> " + decryptPassword("44351PaPaPa*Ah*ck0r0r0nk0"));

    }
    /*
     * Complete the 'decryptPassword' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String decryptPassword(String s) {
        // Write your code here
        StringBuilder res = new StringBuilder();
        Deque<Character> digitStack = new ArrayDeque<Character>();
        Deque<Character> chStack = new ArrayDeque<Character>();

        char[] arr = s.toCharArray();
        int countDigit = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '0') {
                ++countDigit;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            char ch = arr[i];
            // 遇到'0'，digitStack出栈
            if (ch == '0') {
                res.append(digitStack.pollLast());
                --countDigit;
            } else if (ch == '*') {

                res.append(chStack.pollLast());
                res.append(chStack.pollLast());
            } else if (ch >= '1' && ch <= '9' && i + 1 < arr.length) {
                int count = 0;
                if (arr[i + 1] >= '1' && arr[i + 1] <= '9' && count++ <= countDigit) {
                    digitStack.addLast(ch);
                    digitStack.addLast(arr[i + 1]);
                    i += 1;
                } else {
                    res.append(ch);
                }
            } else if (Character.isUpperCase(ch) && i + 2 < arr.length) {
                if (Character.isLowerCase(arr[i + 1]) && arr[i + 2] == '*') {
                    chStack.addLast(ch);
                    chStack.addLast(arr[i + 1]);
                    i += 1;
                } else {
                    res.append(ch);
                }
            } else {
                res.append(ch);
            }
        }
        return res.toString();
    }

}
