import sun.reflect.generics.tree.Tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 题目要求，找出超过半数的数字（一定超过半数，题目已强调）
 */
public class Solution169 {
    public int majorityElement(int[] nums) {
        return sortMethod(nums);
    }

    /**
     * 投票选举法
     * 当一个当选了众数时，和这个数一样的就投票+1，不一样的（不和你一路人的），就投-1票，无论是谁当时，只要总的数量超过一半，就一定是最后当选者
     * 真灵性
     * @param nums
     * @return
     */
    public int boyerMoore(int[] nums){
        int count = 0;
        Integer value = null;
        for (int i : nums){
            if (count==0){
                value = i;
            }

            count += value==i?1:-1;
        }

        return value;
    }
    /**
     * 时间击败77%，空间击败36%
     * 使用二分法递归查找
     * @param nums
     * @return
     */
    public int binarySearch(int[] nums){
        return search(nums,0,nums.length-1);
    }

    private int search(int[] nums,int begin,int end){
        if (begin == end){
            return nums[begin];
        }

        int mid = (end-begin)/2 + begin;
        int left = search(nums,begin,mid);
        int right = search(nums,mid+1,end);

        if (left==right){
         return left;
        }

        int lCount = count(nums,begin,end,left);
        int rCount = count(nums,begin,end,right);

        return lCount>rCount?left:right;
    }

    private int count(int[] nums,int begin,int end,int tar){
        int c = 0;
        for (int i = begin;i<=end;i++){
            if (nums[i]==tar){
                c++;
            }
        }
        return c;
    }

    /**
     * 时间击败 44%
     * 空间击败 33%
     * 先排序后用动态规划
     * @param nums
     * @return
     */
    public int sortMethod(int[] nums) {
        Arrays.sort(nums);
        int ref = nums[0];
        int count = 0;
        int flag = nums.length/2;

        for (int i:nums){
            if (i==ref){
                count++;
                if (count>flag){
                    return ref;
                }
            }else {
                ref = i;
                count = 1;
            }
        }

        return ref;
    }
    /**
     * 用时击败12%，内存击败20%
     * 用哈希枚举
     * @param nums
     * @return
     */
    public int mapMethod(int[] nums){
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i:nums){
            if (map.containsKey(i)){
                map.replace(i,map.get(i)+1);
            }else {
                map.put(i,1);
            }
        }

        int flag = nums.length/2;
        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            if (entry.getValue()>flag){
                return entry.getKey();
            }
        }

        return flag;
    }
}
