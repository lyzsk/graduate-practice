package cn.sichu.graduate_practice.easy;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {

        int index = s.length() - 1;
        while (s.charAt(index) == ' ') {
            --index;
        }

        int res = 0;
        while (index >= 0 && s.charAt(index) != ' ') {
            ++res;
            --index;
        }

        return res;
    }
}
