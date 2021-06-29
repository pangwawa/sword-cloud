package fun.codenow.sword.ops.log.question.t94;

/**
 * @Author Jack Wu
 * @Description
 * @Version V1.0
 * @Date2021/6/23 17:40
 **/
public class TreeNode {
    private int val;
    private TreeNode left;
    private TreeNode right;
    public TreeNode(){}
    public TreeNode(int val,TreeNode left,TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
