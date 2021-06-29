package fun.codenow.sword.ops.log.question.t94;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Jack Wu
 * @Description
 * @Version V1.0
 * @Date2021/6/23 17:43
 **/
public class Main {
    public static void main(String[] args) {

    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> searchResult=new ArrayList<>();
        searchResult.add(root.getVal());
        getMiddleSearch(root,searchResult);
        return searchResult;
    }
    public static List<Integer> getMiddleSearch(TreeNode root,List<Integer> searchResult){
        if (root==null){
            return searchResult;
        }
        getMiddleSearch(root.getLeft(),searchResult);
        searchResult.add(root.getVal());
        getMiddleSearch(root.getRight(),searchResult);
        return searchResult;
    }
}
