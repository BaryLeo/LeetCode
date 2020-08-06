public class Solution50 {
    /**
     * 比较非空间
     * @param x
     * @param n
     * @return
     */
    public double myPow1(double x, int n) {
        if (x ==0) {
            return x;
        }
        //样例输入太长了
        double result = go(x,(long)n);
        return n>0?result:1.0/result;
    }

    private double go(double x,long n){
        if (n==0){
            return 1.0;
        }
        //求出另一半y
        double y = go(x,n/2);
        //y*y即目标，若是奇数，则再*x
        return n%2==0?y*y:y*y*x;
    }

    /**
     * 迭代处理，费脑子，理解了，妙蛙种子吃着妙脆角妙进了米奇妙妙屋，妙到家了
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (x ==0) {
            return x;
        }

        //样例输入太长了
        long times = n;

        if (times<0){
            times*=-1;
        }

        double result = 1;
        //计算位移量
        double contr = x;
        while (times>0){
            if (times%2==1){
                result *=contr;
            }
            contr *=contr;
            times /=2;
        }

        return n>0?result:1.0/result;
    }

}
