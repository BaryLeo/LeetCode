package queue;

import java.util.PriorityQueue;

/**
 * 利用优先队列，然后优先队列默认是最小根堆实现
 * 控制队列长度即可
 */
public class Solution703 {

    PriorityQueue<Integer> priorityQueue;

    int k;

    public Solution703(int k, int[] nums) {
        //默认最小根堆
        priorityQueue = new PriorityQueue<>(k);
        this.k = k;
        for (int i :nums){
            priorityQueue.add(i);
        }

        while (priorityQueue.size()>k){
            priorityQueue.poll();
        }
    }

    public int add(int val) {
        if (priorityQueue.size()<k){
            priorityQueue.add(val);
        }else if (val>priorityQueue.peek()){
            priorityQueue.poll();
            priorityQueue.add(val);
        }

        return priorityQueue.peek();
    }


}