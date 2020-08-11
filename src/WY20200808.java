import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class WY20200808 {
    public void t1() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] partten = new int[]{2,3};
        int[] ar = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i =0;i<n;i++){
            ar[i] = scanner.nextInt();
            if (ar[i]>max){
                max = ar[i];
            }
        }
        if (max<=1){
            System.out.println(0);
            return;
        }
        if (max==2||max==3){
            System.out.println(1);
            return;
        }
        //建立记忆集
        int[] res = new int[max+3];
        Arrays.fill(res,Integer.MIN_VALUE);
        //这两无法分解
        res[0] = 0;
        res[1] = 0;
        //从每个素数开始算
        for (int zs:partten){
            //计算当前加个需要当前素数+前面的组合要多少
            for (int x = zs;x<=max;x++){
                //计算最优子解
                res[x] = Math.max(res[x],1+res[x-zs]);
            }
        }
        //计算结果
        int result = 0;
        for (int i:ar){
            result += res[i];
        }
        System.out.println(result);
    }




    public void t3(){
        Scanner scanner = new Scanner(System.in);
        //t组数据
        int t = scanner.nextInt();
        //每组数据长度
        int n = scanner.nextInt();
        if (t==0||n==0){
            System.out.println(0);
            return;
        }
        int[][] ar = new int[t][n];
        for (int i = 0;i<t;i++){
            for (int x = 0;x<n;x++){
                ar[i][x] = scanner.nextInt();
            }
        }

        LinkedList<Integer> queue = new LinkedList<>();
        int[] res = new int[t];
        for (int i = 0;i<t;i++){
            int min = Integer.MAX_VALUE;

        }

    }
}
