package cn.sichu.graduate.practice.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sichu
 * @date 2022/07/08
 */
public class Leetcode0736 {

    private Map<String, Deque<Integer>> scope = new HashMap<String, Deque<Integer>>();
    private int start = 0;

    public int evaluate(String expression) {
        return innerEvaluate(expression);
    }

    private int innerEvaluate(String expression) {
        if (expression.charAt(start) != '(') {
            if (Character.isLowerCase(expression.charAt(start))) {
                String var = parseVar(expression);
                return scope.get(var).peek();
            } else {
                return parseInt(expression);
            }
        }
        int res;
        ++start;
        if (expression.charAt(start) == 'l') {
            start += 4;
            List<String> vars = new ArrayList<String>();
            while (true) {
                if (!Character.isLowerCase(expression.charAt(start))) {
                    res = innerEvaluate(expression);
                    break;
                }
                String var = parseVar(expression);
                if (expression.charAt(start) == ')') {
                    res = scope.get(var).peek();
                    break;
                }
                vars.add(var);
                ++start;
                int e = innerEvaluate(expression);
                scope.putIfAbsent(var, new ArrayDeque<Integer>());
                scope.get(var).push(e);
                ++start;
            }
            for (String var : vars) {
                scope.get(var).pop();
            }
        } else if (expression.charAt(start) == 'a') {
            start += 4;
            int e1 = innerEvaluate(expression);
            ++start;
            int e2 = innerEvaluate(expression);
            res = e1 + e2;
        } else {
            start += 5;
            int e1 = innerEvaluate(expression);
            ++start;
            int e2 = innerEvaluate(expression);
            res = e1 * e2;
        }
        ++start;
        return res;
    }

    private int parseInt(String expression) {
        int n = expression.length();
        int res = 0;
        int sign = 1;
        if (expression.charAt(start) == '-') {
            sign = -1;
            ++start;
        }
        while (start < n && Character.isDigit(expression.charAt(start))) {
            res = res * 10 + (expression.charAt(start) - '0');
            ++start;
        }
        return sign * res;
    }

    private String parseVar(String expression) {
        int n = expression.length();
        StringBuilder res = new StringBuilder();
        while (start < n && expression.charAt(start) != ' ' && expression.charAt(start) != ')') {
            res.append(expression.charAt(start));
            ++start;
        }
        return res.toString();
    }

}