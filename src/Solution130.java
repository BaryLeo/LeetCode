/**
 *  给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 *
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 */
public class Solution130 {
    //测试用例
    char[][] ar = new char[][]{
            {'X','X','X','X'},
            {'X','O','O','X'},
            {'X','X','O','X'},
            {'X','O','X','X'}};

    char[][] ar2 = new char[][]{
            {'X','O','X','O','X','O'},
            {'O','X','O','X','O','X'},
            {'X','O','X','O','X','O'},
            {'O','X','O','X','O','X'}};
    /**
     * 从边界的O出发进行广度遍历标记即可
     * @param board
     */
    public void solve(char[][] board) {
        if (board.length==0){
            return;
        }
        int xLen = board[0].length;
        int yLen = board.length;
        int n = Math.max(xLen,yLen);
        for (int i =0;i<n;i++){
            //遍历第一行
            find(board,i,0,xLen,yLen);
            //遍历最后一行
            find(board,i,board.length-1,xLen,yLen);
            //遍历左侧列
            find(board,0,i,xLen,yLen);
            //遍历最右侧
            find(board,board[0].length-1,i,xLen,yLen);
        }

        //转换答案
        for (int i = 0;i<board.length;i++){
            for (int j = 0;j<board[0].length;j++){
                if (board[i][j]=='O'){
                    board[i][j]='X';
                }else if (board[i][j]=='Y'){
                    board[i][j]='O';
                }
            }
        }

        /**
         * 测试查看答案
         */
//        for (char[] chars:board){
//            for (char c:chars){
//                System.out.print(c+" ");
//            }
//            System.out.println("");
//        }
    }

    private void find(char[][] board,int x,int y,int xLen,int yLen){
        //如果不越界
        if (x>=0&&x<xLen&&y>=0&&y<yLen){
            if (board[y][x]=='O'){
                //进行标记
                board[y][x] = 'Y';
                //找其他位置的
                find(board, x+1, y,xLen,yLen);
                find(board, x-1, y,xLen,yLen);
                find(board, x, y+1,xLen,yLen);
                find(board, x, y-1,xLen,yLen);
            }
        }
    }
}
