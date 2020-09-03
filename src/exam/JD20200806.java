package exam;

import java.util.Scanner;

public class JD20200806 {
    public void t1(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        double a = 0;
        double b = 0;
        for (int i = 1;i<=n;i++){
            a = a + 1.0/(5.0*(2.0*i-1.0));
            b = b+1.0/(10.0*i);
        }

        System.out.println(String.format("%.4f",a-b));
    }

    public void t2(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        if (m-n<10){
            System.out.println(m-n);
            return;
        }
        int count = 0;
        for (int i = n;i<=m;i++){
            if (checkPass(i)&&isResult(i)){
                count++;
            }
        }
        System.out.println(count);
    }
    public boolean checkPass(int n){
        double m = Math.sqrt(n);
        int x = (int)m;
        return !(x==m);
    }

    public boolean isResult(int n){
        char[] chars = String.valueOf(n).toCharArray();
        int pre = 0;
        int rear = chars.length-1;
        while (pre<rear){
            if (chars[pre]!=chars[rear]){
                if (chars[pre + 1] != chars[rear] || chars[rear+1]!=chars[pre]) {
                    return false;
                }
            }
            pre++;
            rear--;
        }
        return true;
    }

}
