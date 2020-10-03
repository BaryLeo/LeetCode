package leetcode;

public class Offer13 {
    /**
     * dfs算法
     */
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[n][m];
        return dfs(0,0,k,visited);
    }

    public int dfs(int x,int y,int k,boolean[][] visited){
        if (x>=visited[0].length||y>=visited.length||visited[y][x]||(x % 10 + x / 10 + y % 10 + y / 10)>k){
            return 0;
        }

        visited[y][x] = true;
        return 1+dfs(x+1,y,k,visited)+dfs(x,y+1,k,visited);
    }
}
