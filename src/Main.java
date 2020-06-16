import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//        int[] ar = new int[]{2,3,-2,4};
//        Solution152 solution152 = new Solution152();
//        System.out.println(solution152.maxProduct(ar));

        Solution297 solution210 = new Solution297();
        System.out.println(solution210.serialize(solution210.getTreeNode()));
        System.out.println(solution210.serialize(solution210.deserialize(solution210.getStrData())));
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
