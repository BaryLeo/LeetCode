import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 广度优先搜索，层序遍历
 */
public class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root!=null){
            queue.addLast(root);
        }

        while (!queue.isEmpty()){
            ArrayList<Integer> re = new ArrayList<>();
            //分层
            for (int i = queue.size();i>0;i--){
                TreeNode n = queue.pollFirst();
                re.add(n.val);
                if (n.left!=null){
                    queue.addLast(n.left);
                }
                if (n.right!=null){
                    queue.addLast(n.right);
                }
            }
            res.add(re);
        }

        return res;
    }
}
