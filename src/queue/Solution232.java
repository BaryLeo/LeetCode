package queue;

import java.util.LinkedList;

public class Solution232 {
    LinkedList<Integer> list= new LinkedList<>();
    /** Initialize your data structure here. */
    public Solution232() {
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        list.add(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return list.pollFirst();
    }

    /** Get the front element. */
    public int peek() {
        return  list.peekFirst();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return list.isEmpty();
    }
}
