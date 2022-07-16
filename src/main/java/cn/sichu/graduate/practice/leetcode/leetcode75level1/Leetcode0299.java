package cn.sichu.graduate.practice.leetcode.leetcode75level1;

/**
 * @author sichu
 * @date 2022/07/15
 */
public class Leetcode0299 {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int[] sCount = new int[10];
        int[] gCount = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                ++bulls;
            } else {
                ++sCount[secret.charAt(i) - '0'];
                ++gCount[guess.charAt(i) - '0'];
            }
        }
        int cows = 0;
        for (int i = 0; i < 10; i++) {
            cows += Math.min(sCount[i], gCount[i]);
        }
        return Integer.toString(bulls) + 'A' + Integer.toString(cows) + 'B';
    }
}
