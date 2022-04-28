package cn.sichu.graduate_practice.hackerrank;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.hackerrank.com/challenges/grading/problem?isFullScreen=true
 * 
 * @author sichu
 * @date 2022/04/28
 */
public class GradingStudents {
    /*
     * Complete the 'gradingStudents' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY grades as parameter.
     */

    public static List<Integer> gradingStudents(List<Integer> grades) {
        // Write your code here
        List<Integer> res = new ArrayList<Integer>();
        int len = grades.size();

        for (int i = 0; i < len; i++) {
            int grade = grades.get(i);
            if (grade < 38) {
                res.add(grade);
            } else {
                if ((grade + 1) % 5 == 0) {
                    res.add(grade + 1);
                } else if ((grade + 2) % 5 == 0) {
                    res.add(grade + 2);
                } else {
                    res.add(grade);
                }
            }
        }
        return res;
    }
}
