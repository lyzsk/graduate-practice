package cn.sichu.graduate.practice.leetcode;

/**
 * @author sichu
 * @date 2022/07/10
 */
public class Leetcode0676 {
    class Trie {
        private boolean isFinished;
        private Trie[] child;

        public Trie() {
            isFinished = false;
            child = new Trie[26];
        }
    }

    private Trie root;

    public Leetcode0676() {
        root = new Trie();
    }

    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            Trie cur = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                int idx = ch - 'a';
                if (cur.child[idx] == null) {
                    cur.child[idx] = new Trie();
                }
                cur = cur.child[idx];
            }
            cur.isFinished = true;
        }
    }

    public boolean search(String searchWord) {
        return dfs(searchWord, root, 0, false);
    }

    private boolean dfs(String searchWord, Trie node, int pos, boolean modified) {
        if (pos == searchWord.length()) {
            return modified && node.isFinished;
        }
        int idx = searchWord.charAt(pos) - 'a';
        if (node.child[idx] != null) {
            if (dfs(searchWord, node.child[idx], pos + 1, modified)) {
                return true;
            }
        }
        if (!modified) {
            for (int i = 0; i < 26; ++i) {
                if (i != idx && node.child[i] != null) {
                    if (dfs(searchWord, node.child[i], pos + 1, true)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
