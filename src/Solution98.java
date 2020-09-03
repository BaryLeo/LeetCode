
import java.util.Deque;
import java.util.LinkedList;

public class Solution98 {
    //必须要超过int的界限，出现int的极限值很恶心
    long curMax = Long.MIN_VALUE;

    //中序递归操作
    public boolean isValidBST_zx(TreeNode root) {
        if (root==null){
            return true;
        }
        boolean left = isValidBST_zx(root.left);
        //到这里，一定以及遍历完了左子树
        if (curMax>=root.val){
            return false;
        }
        curMax = root.val;
        boolean right = isValidBST_zx(root.right);
        return left&&right;
    }

    public boolean isValidBST(TreeNode root) {
        //作为stack用
        Deque<TreeNode> linkedList = new LinkedList<>();
        while (root!=null||!linkedList.isEmpty()){
            if (root!=null){
                //最左排节点不断压栈
                linkedList.addLast(root);
                root = root.left;
            }

            //当找到分支最后一个左节点的时候
            root = linkedList.pollLast();
            if (curMax>=root.val){
                return false;
            }

            curMax = root.val;
            //开始右子树遍历
            root = root.right;
        }
        return true;
    }

}
