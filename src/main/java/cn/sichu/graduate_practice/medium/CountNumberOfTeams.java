package cn.sichu.graduate_practice.medium;

/**
 * https://leetcode-cn.com/problems/count-number-of-teams/
 * 
 * @author sichu
 * @date 2022/04/10
 */
public class CountNumberOfTeams {
    public int numTeams(int[] rating) {
        int res = 0;
        for (int j = 1; j < rating.length - 1; j++) {
            int iless = 0;
            int imore = 0;
            int kless = 0;
            int kmore = 0;
            for (int i = 0; i < j; i++) {
                if (rating[i] < rating[j]) {
                    ++iless;
                }
                if (rating[i] > rating[j]) {
                    ++imore;
                }
            }
            for (int k = j + 1; k < rating.length; k++) {
                if (rating[k] < rating[j]) {
                    ++kless;
                }
                if (rating[k] > rating[j]) {
                    ++kmore;
                }
            }
            res += iless * kmore + imore * kless;
        }
        return res;
    }
}
