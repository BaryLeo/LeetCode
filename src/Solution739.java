import java.util.Stack;

public class Solution739 {
    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];

        Stack<Integer> stack = new Stack<>();

        for (int i =0;i<T.length;i++){
            if (stack.empty()){
                stack.push(i);
            }else {
                int temp = stack.peek();
                while (temp!=-1&&T[temp]<T[i]){
                    //若当前日期的气温比前面的日期气温高
                    result[temp] = i-temp;
                    stack.pop();
                    if (!stack.isEmpty()){
                        temp = stack.peek();
                    }else {
                        temp = -1;
                    }
                }
                stack.push(i);
            }
        }

        while (!stack.isEmpty()){
            result[stack.pop()] = 0;
        }

        return result;
    }
}
