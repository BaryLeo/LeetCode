import offer.Offer04;

import java.util.concurrent.ConcurrentHashMap;

public class Main {

    public static void main(String[] args) {
      Solution8 solution8 = new Solution8();
      solution8.myAtoi("4193 with words");
    }

    public static void printArray(int[] ar){
        for (int i:ar){
            System.out.print(i+" ");
        }
    }

    public static void printLits(ListNode listNode){
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
