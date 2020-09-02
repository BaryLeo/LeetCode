public class Offer12 {
    public boolean exist(char[][] board, String word) {
        if (board.length==0){
            return false;
        }
        boolean[][] mark = new boolean[board.length][board[0].length];
        char[] chars = word.toCharArray();
        for (int i =0;i<board.length;i++){
            for (int x = 0;x<board[0].length;x++){
                if (chars[0]==board[i][x]){
                    if (exist(board,chars,mark,0,x,i)){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean exist(char[][] board, char[] word,boolean[][] mark,int charIndex,int x,int y){
        if (charIndex==word.length){
            return true;
        }

        if (x<0||x>=board[0].length||y<0||y>=board.length||mark[y][x]|| board[y][x] != word[charIndex]){
            //越界，返回false
            return false;
        }

        int index = charIndex+1;


        mark[y][x] = true;
        boolean result = exist(board,word,mark,index,x+1,y)||
                exist(board,word,mark,index,x-1,y)||
                exist(board,word,mark,index,x,y+1)||
                exist(board,word,mark,index,x,y-1);
        mark[y][x] = false;
        return result;
    }
}
