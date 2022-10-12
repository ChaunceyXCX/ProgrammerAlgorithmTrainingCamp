//给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并
//返回这颗 二叉树 。 
//
// 
//
// 示例 1: 
// 
// 
//输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
//输出：[3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入：inorder = [-1], postorder = [-1]
//输出：[-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= inorder.length <= 3000 
// postorder.length == inorder.length 
// -3000 <= inorder[i], postorder[i] <= 3000 
// inorder 和 postorder 都由 不同 的值组成 
// postorder 中每一个值都在 inorder 中 
// inorder 保证是树的中序遍历 
// postorder 保证是树的后序遍历 
// 
//
// Related Topics 树 数组 哈希表 分治 二叉树 👍 855 👎 0


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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // 第一步：如果数组大小为零的话，说明是空节点了。
        if (postorder.length == 0) return null;
        // 第二步：如果不为空，那么取后序数组最后一个元素作为节点元素。
        int rootValue = postorder[postorder.length-1];
        TreeNode root = new TreeNode(rootValue);
        if (postorder.length == 1) return treeNode;
        // 第三步：找到后序数组最后一个元素在中序数组的位置，作为切割点
        int rootIndex;
        for (rootIndex = 0; rootIndex < inorder.length; rootIndex++) {
            if (inorder[rootIndex] == rootValue) break;
        }
        // 第四步：切割中序数组，切成中序左数组和中序右数组 （顺序别搞反了，一定是先切中序数组）
        List<Integer> leftIn = new ArrayList<>();
        int i = 0;
        while (i<rootIndex){
            leftIn.add(inorder[i++]);
        }
        List<Integer> rightIn = new ArrayList<>();
        for (int i1 = rootIndex+1; i1 < inorder.length; i1++) {
            rightIn.add(inorder[i1]);
        }
        // 第五步：切割后序数组，切成后序左数组和后序右数组
        po
        // 第六步：递归处理左区间和右区间
        root.left = buildTree(leftIn,zuo);
        root.right = buildTree(you,you);
        return root;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
