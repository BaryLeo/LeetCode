package exam;

/**
 * @author BaryLeo
 * @version 1.0
 * @date 2020/9/28 19:15
 */
public class SZ0928 {

    public static void main(String[] args) {
        String[] ars = new String[3];
        ars[0] = "-1";
        ars[1] = "2";
        ars[2] = "1";
        System.out.println(findGreatestSumOfSubArray(ars));
    }

    public int sort (String inData) {
        // write code here
        String[] nums = inData.split(" ");
        int[] ar = new int[nums.length];
        for (int i = 0;i<ar.length;i++){
            ar[i] = Integer.valueOf(nums[i]);
        }

        int count = 0;
        for (int i = 0;i<ar.length;i++){
            int curMax = Integer.MIN_VALUE;
            int curIndex = 0;
            for (int x = 0;i<ar.length-i;x++){
                if (ar[x]>curMax){
                    curMax = ar[x];
                    curIndex = x;
                    break;
                }
            }

            if (curIndex!=ar.length-i){

            }

        }

        return count;
    }

    /**
     * 求连续子数组的最大和
     * @param array string字符串一维数组 数组
     * @return int整型
     */
    public static int findGreatestSumOfSubArray (String[] array) {
        // write code here
        int[] ar = new int[array.length];
        for (int i = 0;i<ar.length;i++){
            ar[i] = Integer.valueOf(array[i]);
        }

        int res = ar[0];
        int tem = ar[0];
        for (int i = 1;i<ar.length;i++){
            if (tem>0&&tem+ar[i]>res){
                tem += ar[i];
                if (tem > res){
                    res = tem;
                }
            }else {
                tem = ar[i];
            }
        }
        return res;
    }
}
