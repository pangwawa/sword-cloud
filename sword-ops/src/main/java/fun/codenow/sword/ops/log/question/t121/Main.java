package fun.codenow.sword.ops.log.question.t121;

/**
 * @Author Jack Wu
 * @Description
 * @Version V1.0
 * @Date2021/6/29 15:43
 **/
public class Main {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root==null){
            return false;
        }
        if (root.left==null&&root.right==null){
            return targetSum==root.val;
        }
        return hasPathSum(root.left,targetSum-root.val)||hasPathSum(root.right,targetSum-root.val);
    }
}
