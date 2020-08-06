public class Solution191 {
    public int hammingWeight(int n) {
        return run(n);
    }

    //求余，会超时
    public int modulo(int n){
        int count = 0 ;
        while (n>0){
            if (n%2==1){
                count++;
            }
            n = n>>1;
        }
        return count;
    }

    //>>带符号位右移
    //>>>无符号右移，符号位始终为0
    public int run(int n){
        int count = 0;
        while (n!=0){
            n = n&(n-1);
            count++;
        }
        return count;
    }
}
