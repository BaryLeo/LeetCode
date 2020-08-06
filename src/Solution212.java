import java.util.ArrayList;
import java.util.List;

/**
 * 剪枝
 * 回溯
 * 二维数组广度优先搜索
 */
public class Solution212 {
    TrieNode root = new TrieNode();
    List<String> res = new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {

        for (String s:words){
            insert(s);
        }
        int xLen = board[0].length;
        int yLen = board.length;
        //要标记已遍历的地方
        boolean[][] visited = new boolean[yLen][xLen];
        StringBuilder stringBuilder = new StringBuilder();
        for (int x =0;x<board[0].length;x++){
            for (int y =0;y<board.length;y++){
                backTrace(board,x,y,root,visited,stringBuilder);
            }
        }
        return res;
    }

    public void insert(String word){
        TrieNode cur = root;
        for (char c:word.toCharArray()){
            int index = c-'a';
            if (cur.next[index]==null){
                cur.next[index] = new TrieNode();
            }
            cur = cur.next[index];
        }
        cur.isEnd = true;
    }

    public void backTrace(char[][] board,int x,int y,TrieNode root,boolean[][] visited,StringBuilder stringBuilder){

        //剪枝操作，检查当前索引是否合法，是否已被遍历
        if (canNext(x,y,board)&&!visited[y][x]){
            //切换到当前节点
            TrieNode cur = root.next[board[y][x]-'a'];
            //剪枝，当前树节点为null结束返回
            if (cur==null){
                return;
            }
            //标记已遍历
            visited[y][x] = true;
            //当前字母加入字符串中
            stringBuilder.append(board[y][x]);
            if (cur.isEnd){
                String s = stringBuilder.toString();
                if (!res.contains(s)){
                    res.add(stringBuilder.toString());
                }

            }
            //符合要求，往下走，传递当前节点
            //并且标记节点已被扫描
            //切换到树的下一节点
            backTrace(board,x+1,y,cur,visited,stringBuilder);
            backTrace(board,x-1,y,cur,visited,stringBuilder);
            backTrace(board,x,y+1,cur,visited,stringBuilder);
            backTrace(board,x,y-1,cur,visited,stringBuilder);
            //回溯，取消已遍历标记，移除当前sb成员
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
            visited[y][x] = false;
        }

    }

    public boolean canNext(int x,int y,char[][] board){
        //任一越界都部不允许
        return x<board[0].length&&x>=0&&y<board.length&&y>=0;
    }

    class TrieNode{
        boolean isEnd;
        TrieNode[] next = new TrieNode[26];
    }
}

