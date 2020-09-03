package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Offer32 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> linkedList = new LinkedList();
        if(root!=null){
            linkedList.addLast(root);
        }
        while (!linkedList.isEmpty()){
            ArrayList<Integer> re = new ArrayList<>();
            //分层的骚操作来了。。。
            //不能用size作为i的标志位，size是变化的
            //需要用0作为i的标志位
            for (int i = linkedList.size();i>0;i--){
                TreeNode node = linkedList.pollFirst();
                re.add(node.val);
                if (node.left!=null){
                    linkedList.addLast(node.left);
                }
                if (node.right!=null){
                    linkedList.addLast(node.right);
                }
            }

            res.add(re);
        }

        return res;
    }
}
