package leetcode;

public class Offer16 {
    public static void main(String[] args) {
        System.out.println(myPow(2d,10));
    }

    public static double myPow(double x, int n) {
        if(n==0) return 1;
        //考虑到负数右移永远是负数，
        if(n==-1) return 1/x;
        //如果是奇数次的乘方
        if((n&1)!=0) {
            return myPow(x*x, n>>1)*x;
        }else {
            //偶数次乘方
            return myPow(x*x, n>>1);
        }
    }

    public static double dPow(double x,long n){
        if (n==1){
            return x;
        }
        return dPow(x,n/2)*dPow(x,n/2);
    }
}
