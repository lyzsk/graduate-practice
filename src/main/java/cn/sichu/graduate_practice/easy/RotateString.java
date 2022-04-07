package cn.sichu.graduate_practice.easy;

/**
 * https://leetcode-cn.com/problems/rotate-string/
 * 
 * @author sichu
 * @date 2022/04/07
 */
public class RotateString {
    public boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);
    }
}
