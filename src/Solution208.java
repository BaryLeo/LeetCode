public class Solution208 {
    TireNode root = new TireNode();
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TireNode cur = root;
        char[] cs = word.toCharArray();
        for (int i = 0;i<cs.length;i++){
            int c= cs[i]-'a';
            if (cur.next[c]==null){
                cur.next[c] = new TireNode();
            }
            cur = cur.next[c];
        }
        cur.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TireNode cur = root;
        for (char c :word.toCharArray()){
            cur = cur.next[c-'a'];
            if (cur==null){
                return false;
            }
        }
        return cur.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TireNode cur = root;
        for (char c:prefix.toCharArray()){
            cur = cur.next[c-'a'];
            if (cur==null){
                return false;
            }
        }
        return true;
    }
}

class TireNode{
    boolean isEnd = false;
    TireNode[] next = new TireNode[26];
}
