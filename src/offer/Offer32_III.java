package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Offer32_III {
    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (root==null){
            return res;
        }
        queue.addLast(root);
        while (!queue.isEmpty()){
            ArrayList<Integer> integers = new ArrayList<>();
            int count = queue.size();
            int num = 1;
            for (int i =0;i<count;i++){
                TreeNode node = queue.pollFirst();
                integers.add(node.val);
                if(node.left!=null){
                    queue.addLast(node.left);
                }
                if (node.right!=null){
                    queue.addLast(node.right);
                }
            }

            if (num%2==0){
                Collections.reverse(integers);
            }

            num++;
            res.add(integers);
        }
        return res;
    }
}
