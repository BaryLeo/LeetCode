package leetcode;

/**
 * 二分法
 */
public class Offer53I {
    public int search(int[] nums, int target) {
        //左指针
        int left = 0;
        //右指针
        int right = nums.length-1;
        //结果
        int count = 0;
        //必须要<=，不然会出现[1]时报错
        while (left<=right){
            int index = (left+right)/2;
            if (nums[index]==target){
                //进了这里，就已经获取答案了，两边跑一下就行了
                int temp = index;
                while (temp<nums.length&&nums[temp]==target){
                    count++;
                    temp++;
                }
                temp = index-1;
                while (temp>=0&&nums[temp]==target){
                    count++;
                    temp--;
                }
                break;
            }else if (nums[index]>target){
                //当前index已经检查过了，-1
                right = index-1;
            }else if(nums[index]<target){
                //当前index已经检查过了，+1
                left = index+1;
            }
        }

        return count;
    }
}
