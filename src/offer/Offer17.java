package leetcode;

public class Offer17 {
    public int[] printNumbers(int n) {
        long a = 1;
        for (int i = 0;i<n;i++){
            a*=10;
        }

        int[] res = new int[(int)(a-1)];

        for (long i = 0;i<a;i++){
            int x= (int) i;
            res[x] = x+1;
        }
        return res;
    }
}
