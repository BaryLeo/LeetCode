import java.util.*;

public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList();

        if (nums.length<3){
            return result;
        }
        Arrays.sort(nums);

        for (int i = 0;i<nums.length;i++){
            if (nums[i]>0){
                break;
            }
            if (i>0&&nums[i]==nums[i-1]){
                continue;
            }
            int head = i+1;
            int rear = nums.length-1;
            while (head<rear){
                int sum = nums[head]+nums[rear]+nums[i];
                if (sum==0){
                    List<Integer> list = new LinkedList<>();
                    list.add(nums[head]);
                    list.add(nums[rear]);
                    list.add(nums[i]);
                    result.add(list);
                    //已经合并为0了，所以需要两个指针都移动，不然一定不为0或者发送重复
                    head++;
                    rear--;
                    //去重
                    while (head<rear&&nums[head]==nums[i]){
                        head++;
                    }
                    //去重，不能是末尾，不然越界
                    while (head<rear&&rear!=nums.length-1&&nums[rear]==nums[rear+1]){
                        rear--;
                    }
                }else if (sum<0){
                    //小的数太小了
                    head++;
                }else if (sum>0){
                    //大的数太大了
                    rear--;
                }
            }
        }

        return result;
    }
}
