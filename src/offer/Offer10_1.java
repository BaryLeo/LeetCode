package offer;

/**
 * 初级动态规划
 */
public class Offer10_1 {
    public static void main(String[] args) {
        Offer10_1 offer10_1 = new Offer10_1();
        //7==>13
        System.out.println(offer10_1.fib(7));
    }

    public int fib(int n) {
        int f0 = 0;
        int f1 = 1;
        if (n==0){
            return f0;
        }
        if (n==1){
            return f1;
        }

        for (int i =1;i<n;i++){
            int temp = f0+f1;
            f0 = f1;
            f1 = temp;
        }

        return f1%1000000007;
    }
}
