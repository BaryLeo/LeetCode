public class Solution509 {
    public int fib(int N) {
        if (N==0){
            return 0;
        }else if (N==1){
            return 1;
        }

        int f0 = 0;
        int f1 = 1;
        for (int i=2;i<=N;i++){
            int temp = f1;
            f1 = f0+f1;
            f0 = temp;
        }
        return f1;
    }
}
