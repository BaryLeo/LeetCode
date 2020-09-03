package offer;

/**
 * 有点动态规划的感觉
 */
public class Offer04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length==0||matrix[0].length==0){
            return false;
        }

        for (int i=0;i<matrix.length;i++){
            if (target>=matrix[i][0]&&target<=matrix[i][matrix[i].length-1]){
                for (int x:matrix[i]){
                    if (target==x){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
