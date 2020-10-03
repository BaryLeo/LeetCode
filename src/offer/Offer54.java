package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;

public class Offer54 {
    int count = 0;
    int res = 0;
    public int kthLargest(TreeNode root, int k) {
        find(root,k);
        return res;
    }

    public void find(TreeNode root, int k){
        if (root==null){
            return;
        }
        find(root.right,k);
        if (++count==k){
            res=root.val;
        }

        find(root.left,k);
    }
}
