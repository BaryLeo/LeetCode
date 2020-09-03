/**
 * 深度优先搜索
 */
public class Solution104 {
    public int maxDepth(TreeNode root) {
        return find(root,0);
    }

    public int find(TreeNode root,int level){
        if (root==null){
            return level;
        }
        //level+1是本层的层数
        int leftLevel = find(root.left,level+1);
        int rightLevel = find(root.right,level+1);

        return Math.max(leftLevel,rightLevel);
    }
}
