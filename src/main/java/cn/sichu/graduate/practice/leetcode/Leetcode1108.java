package cn.sichu.graduate.practice.leetcode;

/**
 * 
 * @author sichu
 * @date 2022/05/28
 */
public class Leetcode1108 {
    public String defangIPaddr(String address) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < address.length(); i++) {
            if (address.charAt(i) == '.') {
                res.append("[.]");
            } else {
                res.append(address.charAt(i));
            }
        }
        return res.toString();
    }
}
