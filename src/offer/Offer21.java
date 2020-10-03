package leetcode;

public class Offer21 {
    public static void main(String[] args) {
        int[] ar = new int[]{1,3,5};
        for (int i :exchange(ar)) {
            System.out.println(i);
        }
    }
    public static int[] exchange(int[] nums) {
        if (nums.length<2){
            return nums;
        }
        int pre = 0;
        int rear = nums.length-1;
        while (pre<rear){
            while (pre<nums.length&&nums[pre]%2!=0){
                pre++;
            }
            while (rear>0&&nums[rear]%2!=1){
                rear--;
            }

            if (pre<rear){
                int temp = nums[pre];
                nums[pre] = nums[rear];
                nums[rear] = temp;
                pre++;
                rear--;
            }
        }
        return nums;
    }
}
