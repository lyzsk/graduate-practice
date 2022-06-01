package cn.sichu.graduate.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 类似的题： Leetcode0046， Leetcode0047, Leetcode0039, Leetcode0040, <b>Leetcode0077</b>, Leetcode0078, Leetcode0090,
 * <b>Leetcode0060</b>, Leetcode0093, Leetcode0733, Leetcode0200, Leetcode0130, Leetcode0079, Leetcode0017,
 * <b>Leetcode0784</b>, Leetcode0022, Leetcode0051, Leetcode0037, Leetcode0488, Leetcode0529
 * 
 * @author sichu
 * @date 2022/05/31
 */
public class Leetcode0784 {
    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<String>();
        char[] arr = s.toCharArray();
        backtrack(res, arr, 0);
        return res;
    }

    private static void backtrack(List<String> res, char[] arr, int startIndex) {
        if (startIndex == arr.length) {
            res.add(new String(arr));
            return;
        }
        backtrack(res, arr, startIndex + 1);
        if (Character.isLetter(arr[startIndex])) {
            arr[startIndex] ^= 1 << 5;
            backtrack(res, arr, startIndex + 1);
        }
    }
}
