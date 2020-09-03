package offer;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 这里的坑是stack是同步的
 */
public class Offer09 {
    private LinkedList<Integer> in= new LinkedList<>();
    private LinkedList<Integer> out= new LinkedList<>();

    public void appendTail(int value) {
        in.push(value);
    }

    public int deleteHead() {

        if (out.isEmpty()){
            while (!in.isEmpty()){
                out.push(in.pop());
            }
        }
        if (out.isEmpty()){
            return -1;
        }else {
            int rm = out.pop();
            return rm;
        }
    }
}
