import offer.Offer04;

import java.util.concurrent.ConcurrentHashMap;

public class Main {

    public static void main(String[] args) {
      Solution105 solution105 = new Solution105();
      System.out.println("普通类加载器："+solution105.getClass().getClassLoader());
      System.out.println("加载器的父加载器"+solution105.getClass().getClassLoader().getParent());
      System.out.println("加载器的加载器："+solution105.getClass().getClassLoader().getClass().getClassLoader());
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
