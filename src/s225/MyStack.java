package s225;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class MyStack {

    LinkedList<Integer> list;

    /** Initialize your data structure here. */
    public MyStack() {
        list = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        list.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return list.removeLast();
    }

    /** Get the top element. */
    public int top() {
        return list.getLast();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return list.isEmpty();
    }

}
