package cn.sichu.graduate.practice.leetcode.offerii;

/**
 * 
 * @author sichu
 * @date 2022/05/21
 */
public class OfferII002 {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = carry;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            sb.append(sum % 2);
            carry = sum / 2;
        }
        sb.append(carry == 1 ? carry : "");
        return sb.reverse().toString();
    }
}
