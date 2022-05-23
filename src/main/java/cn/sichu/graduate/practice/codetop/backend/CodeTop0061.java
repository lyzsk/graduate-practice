package cn.sichu.graduate.practice.codetop.backend;

/**
 * 
 * @author sichu
 * @date 2022/05/23
 */
public class CodeTop0061 {
    /**
     * 计算形式:
     * <p>
     * num1<br>
     * *num2<br>
     * --------<br>
     * res
     * 
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        String res = "0";
        for (int i = num2.length() - 1; i >= 0; i--) {
            int carry = 0;
            StringBuilder tmp = new StringBuilder();
            for (int j = 0; j < num2.length() - 1 - i; j++) {
                tmp.append(0);
            }
            int digit2 = num2.charAt(i) - '0';

            for (int j = num1.length() - 1; j >= 0 || carry != 0; j--) {
                int digit1 = j < 0 ? 0 : num1.charAt(j) - '0';
                int product = (digit1 * digit2 + carry) % 10;
                tmp.append(product);
                carry = (digit1 * digit2 + carry) / 10;
            }
            res = addStrings(res, tmp.reverse().toString());
        }
        return res;
    }

    private static String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry != 0; i--, j--) {
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            int sum = (x + y + carry) % 10;
            sb.append(sum);
            carry = (x + y + carry) / 10;
        }
        return sb.reverse().toString();
    }
}
