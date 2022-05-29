package cn.sichu.graduate.practice.leetcode;

/**
 * 
 * @author sichu
 * @date 2022/05/28
 */
public class Leetcode0468 {
    public String validIPAddress(String queryIP) {
        if (isValidIPv4(queryIP)) {
            return "IPv4";
        } else if (isValidIPv6(queryIP)) {
            return "IPv6";
        } else {
            return "Neither";
        }
    }

    private static boolean isValidIPv4(String queryIP) {
        int res = 0;
        int count = 0;
        char pre = '.';
        for (int i = 0; i < queryIP.length(); i++) {
            char cur = queryIP.charAt(i);
            if (Character.isDigit(cur)) {
                if (res == 0 && pre == '0') {
                    return false;
                }
                res = res * 10 + cur - '0';
                if (res > 255) {
                    return false;
                }
            } else if (cur == '.') {
                if (pre == '.') {
                    return false;
                }
                ++count;
                res = 0;
            } else {
                return false;
            }
            pre = cur;
        }
        ++count;
        return res >= 0 && res <= 255 && count == 4 && pre != '.';
    }

    private static boolean isValidIPv6(String queryIP) {
        int count = 0;
        int segmentLength = 0;
        char pre = ':';
        for (int i = 0; i < queryIP.length(); i++) {
            char cur = queryIP.charAt(i);
            if (isValidChar(cur)) {
                ++segmentLength;
                if (segmentLength > 4) {
                    return false;
                }
            } else if (cur == ':') {
                if (pre == ':') {
                    return false;
                }
                ++count;
                segmentLength = 0;
            } else {
                return false;
            }
            pre = cur;
        }
        ++count;
        return count == 8 && pre != ':';
    }

    private static boolean isValidChar(char ch) {
        return Character.isDigit(ch) || Character.isUpperCase(ch) && ch <= 'F'
            || Character.isLowerCase(ch) && ch <= 'f';
    }
}
