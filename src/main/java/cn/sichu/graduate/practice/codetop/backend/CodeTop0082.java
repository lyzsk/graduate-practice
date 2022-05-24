package cn.sichu.graduate.practice.codetop.backend;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

/**
 * 现有n个编译项，编号为0 ~ n-1。给定一个二维数组，表示编译项之间有依赖关系。如[0, 1]表示1依赖于0。
 * 
 * 若存在循环依赖则返回空；不存在依赖则返回可行的编译顺序。
 * 
 * @see https://mp.weixin.qq.com/s/pCRscwKqQdYYN7M1Sia7xA
 * 
 * @author sichu
 * @date 2022/05/24
 */
public class CodeTop0082 {
    public List<Integer> haveCircularDependency(int[][] prerequisites, int n) {
        int[] inDegrees = new int[n];
        List<List<Integer>> adjLists = new ArrayList<List<Integer>>();
        Deque<Integer> deque = new ArrayDeque<Integer>();
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            adjLists.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int cur = prerequisites[i][0];
            int next = prerequisites[i][1];
            ++inDegrees[next];
            adjLists.get(cur).add(next);
        }
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) {
                deque.addLast(i);
            }
        }
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                int cur = deque.removeFirst();
                res.add(cur);
                List<Integer> adjList = adjLists.get(cur);
                for (int adj : adjList) {
                    --inDegrees[adj];
                    if (inDegrees[adj] == 0) {
                        deque.addLast(adj);
                    }
                }
            }
        }
        if (res.size() == n) {
            return res;
        } else {
            return Collections.emptyList();
        }
    }
}
