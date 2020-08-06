package hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length<4){
            return result;
        }

        Arrays.sort(nums);

        for (int i=0;i<nums.length-3;i++){
            for (int x = i+1;x<nums.length;x++){
                if (nums[x]>target){
                    break;
                }
                if (i>0&&nums[x]==nums[x-1]){
                    continue;
                }
                int head = x+1;
                int rear = nums.length-1;
                while (head<rear){
                    int sum = nums[head]+nums[rear]+nums[i]+nums[x]-target;
                    if (sum==0){
                        List<Integer> list = new LinkedList<>();
                        list.add(nums[head]);
                        list.add(nums[rear]);
                        list.add(nums[i]);
                        list.add(nums[x]);
                        result.add(list);
                        //已经合并为0了，所以需要两个指针都移动，不然一定不为0或者发送重复
                        head++;
                        rear--;
                        //去重
                        while (head<rear&&nums[head]==nums[x]){
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
        }

        return result;
    }
}
