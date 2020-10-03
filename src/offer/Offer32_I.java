package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;

public class Offer32_I {
    public int[] levelOrder(TreeNode root) {
        if (root==null){
            return new int[0];
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> integers = new ArrayList<>();

        queue.addLast(root);

        while (!queue.isEmpty()){
            TreeNode node = queue.pollFirst();
            integers.add(node.val);
            if (node.left!=null){
                queue.addLast(node.left);
            }
            if (node.right!=null){
                queue.addLast(node.right);
            }
        }


        int[] res = new int[integers.size()];
        for (int i =0;i<integers.size();i++){
            res[i] = integers.get(i);
        }
        return res;
    }
}
