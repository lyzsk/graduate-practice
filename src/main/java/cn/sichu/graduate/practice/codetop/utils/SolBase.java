package cn.sichu.graduate.practice.codetop.utils;

import java.util.Random;

public class SolBase {
    /**
     * 
     * @return return a random integer in the range 1 to 7
     */
    public int rand7() {
        Random random = new Random();
        return random.nextInt(7) + 1;
    }
}
