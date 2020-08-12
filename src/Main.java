import java.util.*;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        int[] ar = new int[]{2,3,1,4,5,3,7,9};
        m.KthLargest(3,ar);
        for (int i:m.ar){
            System.out.println(i);
        }
        System.out.println("-------------");
        System.out.println(m.add(1));
        System.out.println("-------------");
        for (int i:m.ar){
            System.out.println(i);
        }
        System.out.println("-------------");
        System.out.println(m.add(11));
        System.out.println("-------------");
        for (int i:m.ar){
            System.out.println(i);
        }
    }

    private int[] ar;
    private int k;
    public void KthLargest(int k, int[] nums) {
        Arrays.sort(nums);
        this.k = k;
        ar = new int[k+1];
        Arrays.fill(ar,Integer.MIN_VALUE);
        int n = Math.min(k,nums.length);
        for (int i=ar.length-1,x=nums.length-1;i>=0&&x>=0;x--,i--){
            ar[i] = nums[x];
        }
    }

    public int add(int val) {
        ar[0] = val;
        if (val>ar[ar.length-k]){
            Arrays.sort(ar);
        }

        return ar[ar.length-k];
    }

}
