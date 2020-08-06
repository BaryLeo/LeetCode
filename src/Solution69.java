public class Solution69 {
    int a = 0;
    public int mySqrt(int x) {
        a = x;
        if (x==0){
            return 0;
        }
        return sqrt(x);
    }

    /**
     * 牛顿迭代法
     * 主要公式
     * f(x) = (x+a/x)/2;
     * 当f(x) = 目标数时，a就是题目传入的数，x*x==a，x就是答案
     * ( 4 + 2/ 4 ) / 2 = 2.25
     *
     * ( 2.25 + 2/ 2.25 ) / 2 = 1.56944..
     *
     * @param x
     * @return
     */
    public int sqrt(double x){
        double res = (x+a/x)/2;
        if (res==x){
            return (int) res;
        }else {
            return sqrt(res);
        }
    }

    /**
     * 二分法
     * @param x
     * @return
     */
    public int bs(int x){
        //左指针
        int low =0;
        //右边
        int high = x;
        int res = -1;

        while (low<=high){
            //算中间值
            int mid = (low+high)/2;
            //当mid的平方小于x，就设置为左边
            if ((long)mid*mid<=x){
                res = mid;
                //为了能进位，不然low==high时死循环
                low = mid+1;
            }else {
                //大就设置为左边
                high = mid-1;
            }
        }

        return res;
    }
}
