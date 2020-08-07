import java.util.ArrayList;
import java.util.List;

/**
 * N皇后
 * 皇后的横竖撇捺都能杀到
 * 回溯算法
 */
public class Solution51 {
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        //回溯用的
        boolean[][] visited = new boolean[n][n];
        backTrace(visited,0);
        return result;
    }

    public void backTrace(boolean[][] visited,int x){
        if (x==visited.length){
            addResult(visited);
            return;
        }

        for (int y =0;y<visited.length;y++){
            if (canPlease(x,y,visited)){
                //设置已遍历
                visited[y][x] = true;
                //下一步决策
                backTrace(visited,x+1);
                //撤销操作
                visited[y][x] = false;
            }
        }
    }

    public boolean canPlease(int x,int y,boolean[][] visited){
        //检查行
        for (int i=0;i<visited.length;i++){
            if (i!=x&&visited[y][i]){
                return false;
            }
        }

        //检查列
        for (int i=0;i<visited.length;i++){
            if (i!=y&&visited[i][x]){
                return false;
            }
        }

        //检查右上方
        for (int i =y-1,j =x-1;i>=0&&j>=0;i--,j--){
            if (visited[i][j]){
                return false;
            }
        }
        //检查左下方
        for (int i =y+1,j =x+1;i<visited.length&&j<visited.length;i++,j++){
            if (visited[i][j]){
                return false;
            }
        }

        //检查左上方
        for (int i = y-1,j=x+1;i>=0&&j<visited.length;i--,j++){
            if (visited[i][j]){
                return false;
            }
        }

        //检查右下方
        for (int i = y+1,j=x-1;i<visited.length&&j>=0;i++,j--){
            if (visited[i][j]){
                return false;
            }
        }
        return true;
    }

    public void addResult(boolean[][] visited){
        ArrayList<String> arrayList = new ArrayList<>();
        for (int y = 0;y<visited.length;y++){
            StringBuilder stringBuilder = new StringBuilder();
            for (int x = 0;x<visited.length;x++){
                if (visited[y][x]){
                    stringBuilder.append('Q');
                }else {
                    stringBuilder.append('.');
                }
            }
            arrayList.add(stringBuilder.toString());
        }

        result.add(arrayList);
    }
}
