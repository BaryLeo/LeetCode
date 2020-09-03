package exam;

import java.util.LinkedList;
import java.util.Scanner;
public class QXF20200816 {

    /**
     * 方程：f(n) = 1+f(n-1)+f(n-2)+....f(0)
     * @param num_money
     * @return
     */
    public int CalulateMethodCount (int num_money) {
        // write code here
        if (num_money==0){
            return 0;
        }

        if (num_money==1){
            return 1;
        }
        long f0 = 0;
        long f1 = 1;
        //从两元开始
        for (int i =2;i<=num_money;i++){
            long temp = f1;
            f1 = 1+f1+f0;
            f0 = temp;
        }

        return (int) f1;
    }


    public void t2(){
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        LinkedList<String> queue = new LinkedList<>();
        LinkedList<String> redo = new LinkedList<>();
        for (String firstSpilt:input.split("\t")){
            for (String secondSpilt:firstSpilt.split(" ")){
                if (!queue.isEmpty()&&secondSpilt.equals("undo")){
                    redo.addLast(queue.pollLast());
                }else if (!redo.isEmpty()&&secondSpilt.equals("redo")){
                    queue.addLast(redo.pollLast());
                }else {
                    queue.addLast(secondSpilt);
                }
            }
        }

        int count = 1;
        for (String s:queue){
            System.out.print(s);
            if (count!=queue.size()){
                System.out.print(" ");
            }
            count++;
        }

    }
}
