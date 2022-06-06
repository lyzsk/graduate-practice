package cn.sichu.graduate.practice.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 类似的题： Leetcode0316, Leetcode0321, Leetcode0402, Leetcode1081
 * 
 * @author sichu
 * @date 2022/06/05
 */
public class Leetcode1081 {
    public String smallestSubsequence(String s) {
        char[] arr = s.toCharArray();
        Deque<Character> deque = new ArrayDeque<Character>();
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[arr[i] - 'a'] = i;
        }
        boolean[] visited = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            if (visited[arr[i] - 'a']) {
                continue;
            }
            while (!deque.isEmpty() && deque.peekFirst() > arr[i] && lastIndex[deque.peekFirst() - 'a'] > i) {
                char top = deque.removeFirst();
                visited[top - 'a'] = false;
            }
            deque.addFirst(arr[i]);
            visited[arr[i] - 'a'] = true;
        }
        StringBuilder res = new StringBuilder();
        while (!deque.isEmpty()) {
            res.append(deque.removeLast());
        }
        return res.toString();
    }
}
