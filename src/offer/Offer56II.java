package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class Offer56II {

    public int singleNumberByDP(int[] nums){
        Arrays.sort(nums);

        if (nums[0]!=nums[1]&&nums[1]==nums[2]){
            return nums[0];
        }

        if (nums[nums.length-1]!=nums[nums.length-2]&&nums[nums.length-2]==nums[nums.length-3]){
            return nums[nums.length-1];
        }

        int res = 0;
        for (int i = 1;i< nums.length-1;i++){
            if (nums[i]!=nums[i-1]&&nums[i]!=nums[i+1]){
                res = nums[i];
                break;
            }
        }
        return res;
    }
    /**
     * 效率比较差
     * @param nums
     * @return
     */
    public int singleNumberByMap(int[] nums) {
        int res = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i:nums){
            if (map.containsKey(i)){
                map.replace(i,map.get(i)+1);
            }else {
                map.put(i,1);
            }
        }

        for (int k :map.keySet()){
            if (map.get(k)==1){
                res = k;
                break;
            }
        }

        return res;
    }

    //大佬写的题解，不懂
    public int singleNumberByDaLao(int[] nums) {
        int a = 0;
        int b = 0;

        for(int num : nums) {
            a = (a ^ num) & ~b;
            b = (b ^ num) & ~a;
        }

        return a;
    }
}
