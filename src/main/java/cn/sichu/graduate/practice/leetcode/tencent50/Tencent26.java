package cn.sichu.graduate.practice.leetcode.tencent50;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author sichu
 * @date 2022/06/10
 */
public class Tencent26 {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < 1 << n; i++) {
            res.add((i >> 1) ^ i);
        }
        return res;
    }
}
