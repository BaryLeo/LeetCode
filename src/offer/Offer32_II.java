package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Offer32_II {
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
            res.add(integers);
        }
        return res;
    }
}
