package exam;

import java.util.Arrays;

public class MST10P01 {
    public void merge(int[] A, int m, int[] B, int n) {

        int pointA = m-1;
        int pointB = n-1;
        int curr = m+n -1;

        //A和B的指针不超越界限时循环
        while (pointA>=0&&pointB>=0){
            if (B[pointB]>A[pointA]){
                A[curr] = B[pointB];
                pointB--;
            }else {
                A[curr] = A[pointA];
                pointA--;
            }
            curr--;
        }

        //当A>=0的时候，不需要操作，因为就在原位，只需要对B检测和操作
        while (pointB>=0){
            A[curr] = B[pointB];
            curr--;
            pointB--;
        }

    }
}
