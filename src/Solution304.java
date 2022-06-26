/**
 * 类描述
 *
 * @author razor.liu
 * @version 1.0
 * @date 2022/6/23 5:29 PM
 */
public class Solution304 {

    private int[][] preMatrix;

    public Solution304(int[][] matrix) {
        int mY= matrix.length;
        int mX = matrix[0].length;
        if (mY == 0 || mX == 0) return;
        preMatrix = new int[mY+1][mX+1];
        for (int y = 1;y<= mY;y++){
            for (int x = 1;x<= mX;x++){
                preMatrix[y][x] = preMatrix[y-1][x] + preMatrix[y][x-1] + matrix[y-1][x-1]- preMatrix[y-1][x-1];
            }
        }
    }

    public int sumRegion(int y1, int x1, int y2, int x2) {
        //(y2,x2) - (y1-1,x2) - (y2,x1-1) + (y1-1,x1-1) 需要从matrix转换为preMatrix
        return preMatrix[y2+1][x2+1] - preMatrix[y2+1][x1] - preMatrix[y1][x2+1] + preMatrix[y1][x1];
    }
}
