//给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。 
//
// 叶子节点 是指没有子节点的节点。 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,3,null,5]
//输出：["1->2->5","1->3"]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：["1"]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 字符串 回溯 二叉树 👍 824 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result= new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        // @1
        if (root == null) return result;
        getPaths(root,path,result);
        return result;
    }

    public void getPaths(TreeNode cur, List<Integer> path, List<String> result) {
        //中 在@1,2,3 处判断了当前节点不能为空所以末端空节点不会进入递归
        path.add(cur.val);//因为下面递归终止条件 没有判断当前节点是否为空所以把当前节点加入逻辑提前
        // 递归终止条件:当前节点的左右节点为空,将路径转为字符串记录下来
        if (cur.left == null && cur.right == null){
            StringBuilder sPath = new StringBuilder();
            for (int i = 0; i < path.size()-1; i++) {
                sPath.append(path.get(i)).append("->");
            }
            sPath.append(path.get(path.size()-1));
            result.add(sPath.toString());
        }
        //每层递归逻辑
        //前序遍历
        //左 @2
        if (cur.left != null) {
            getPaths(cur.left,path,result);
            //左子树递归完回溯剔除最后一个节点
            path.remove(path.size()-1);
        }
        //右 @3
        if (cur.right != null) {
            getPaths(cur.right,path,result);
            //右子树递归完回溯剔除最后一个节点
            path.remove(path.size()-1);
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
