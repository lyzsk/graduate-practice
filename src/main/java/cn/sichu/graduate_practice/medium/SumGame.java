package cn.sichu.graduate_practice.medium;

/**
 * https://leetcode-cn.com/problems/sum-game/
 * 
 * @author sichu
 * @date 2022/04/11
 */
public class SumGame {
    public boolean sumGame(String num) {
        char[] arr = num.toCharArray();
        int len = arr.length;
        int leftSum = 0;
        int rightSum = 0;
        int leftCount = 0;
        int rightCount = 0;
        for (int i = 0; i < len / 2; i++) {
            if (arr[i] == '?') {
                ++leftCount;
            } else {
                leftSum += (int)(arr[i] - '0');
            }
        }
        for (int i = len / 2; i < len; i++) {
            if (arr[i] == '?') {
                ++rightCount;
            } else {
                rightSum += (int)(arr[i] - '0');
            }
        }
        if (leftSum < rightSum) {
            int tmp1 = rightSum;
            int tmp2 = rightCount;
            rightSum = leftSum;
            leftSum = tmp1;
            rightCount = leftCount;
            leftCount = tmp2;
        }

        if (leftCount == rightCount && leftSum == rightSum) {
            return false;
        }
        if (leftCount >= rightCount) {
            return true;
        }
        if ((rightCount - leftCount) / 2 * 9 < leftSum - rightSum) {
            return true;
        }
        if ((rightCount - leftCount + 1) / 2 * 9 > leftSum - rightSum) {
            return true;
        }
        return false;
    }
}
