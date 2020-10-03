package leetcode;

public class Offer56I {
    public int[] singleNumbers(int[] nums) {
        int eor = 0;
        for (int i : nums) {
            eor ^= i;
        }

        int rightOne = eor&(~eor+1);

        int[] res = new int[2];

        for (int i:nums){
            if ((i&rightOne)!=0){
                res[0] ^= i;
            }
        }

        res[1] = eor^res[0];
        return res;
    }

    }