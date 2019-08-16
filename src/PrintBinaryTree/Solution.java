package PrintBinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<List<String>> h = new ArrayList<>();

    public List<List<String>> printTree(TreeNode root) {
        int depth = getDepth(root);
        int weigh = getWeigh(depth);

        for (int x = 0;x<depth;x++){
            List<String> w = new ArrayList<>();
            for (int i = 0;i<weigh+1;i++){
                w.add("");
            }
            h.add(w);
        }
        postOrder(root,1,weigh,false);
        return h;
    }

    private int getDepth(TreeNode root) {
        if (root == null) return 0;
        //利用分治思想，递归遍历最深
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }

    private int getWeigh(int depth){
        int weigh = 0;
        if (depth == 0){
            return weigh;
        }else if (depth==1){
            weigh = 1;
        }else {
            weigh =2;
        }


        for (int i = 0;i<depth-1;i++){
            weigh = weigh*2;
        }

        return weigh;
    }

    private void postOrder(TreeNode root,int depth,int weigh,boolean isRight){
        if (root == null){
            return;
        }
        List<String> w = h.get(depth);
        int we = weigh/2;
        if (isRight){
            w.set(weigh+we,String.valueOf(root.val));
        }else {
            w.set(we,String.valueOf(root.val));
        }
        depth +=1;
        postOrder(root.left,depth,we,false);
        postOrder(root.right,depth,we,true);
    }

}