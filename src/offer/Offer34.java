package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Offer34 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> part = new ArrayList<>();
        find(root,sum,0,res,part);
        return res;
    }

    public void find(TreeNode root, int sum,int upSum,List<List<Integer>> res,List<Integer> part){
        if (root==null||(upSum+root.val)>sum){
            return;
        }

        part.add(root.val);
        if (upSum+root.val==sum&&root.left==null&&root.right==null){
            res.add(new ArrayList<>(part));
        }else {
            find(root.left,sum,upSum+root.val,res,part);
            find(root.right,sum,upSum+root.val,res,part);
        }
        part.remove(part.size()-1);
    }
}
