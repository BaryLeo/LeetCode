import s242.DO;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//        int[] ar = new int[]{2,3,-2,4};
//        Solution152 solution152 = new Solution152();
//        System.out.println(solution152.maxProduct(ar));
        Solution67 solution67 = new Solution67();
        System.out.println(solution67.addBinary("100","110010"));
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
