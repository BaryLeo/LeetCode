public class Solution152 {
    public int maxProduct(int[] nums) {
        int result = Integer.MIN_VALUE;

        int max = Integer.MIN_VALUE;
        int temp = 1;

        for (int i =0;i<nums.length;i++){
            int m = temp*nums[i];
            if (m>max){
                if (m==0){
                    temp = 1;
                }else {
                    temp = m;
                }

                max = m;
                if (max>result){
                    result = max;
                }
            }else {
                temp = 1;
            }
        }

        return result;
    }
}
