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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    Map<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //因为题目中说节点数值不相等，可以通过Map缓存中序数组中节点数值对应的下标
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        //左闭右开，右边就直接是数组长度
        return getRoot(inorder,0, inorder.length, postorder, 0, postorder.length);
    }

    public TreeNode getRoot(int[] inorder,int instart,int inend, int[] postorder, int postStart, int postEnd) {
        // 第一步：如果数组大小为零的话，说明是空节点了。
        if (postStart == postEnd) return null;
        // 第二步：如果不为空，那么取后序数组最后一个元素作为节点元素。
        int rootValue = postorder[postEnd-1]; //左闭右开所以要减一获取
        TreeNode root = new TreeNode(rootValue);
        if ( postEnd-postStart == 1) return root;
        // 第三步：找到后序数组最后一个元素在中序数组的位置，作为切割点
        int rootIndex = map.get(rootValue);
        // 第四步：切割中序数组，切成中序左数组和中序右数组 （顺序别搞反了，一定是先切中序数组）
        // 这里切割时就体现了左闭右开的好处：不用处理根节点,不用对长度计算减一得到末位索引
        //中序左数组
        int inorderLeftStart = instart;
        int inorderLeftEnd = rootIndex;
        //中序右数组
        int inOrderRightStart = rootIndex+1;
        int inOrderRightEnd = inend;

        // 第五步：切割后序数组，切成后序左数组和后序右数组，
        // 切割后的左右子数组一定等与中序的左右子数组，所以后序数组的左右子数组通过中序左右子数组长度确定
        int postOrderLeftStart = postStart;
        //子数组长度等于中序子数组长度 左闭右开所以不用考虑减一
        int postOrderLetfEnd = postStart+inorderLeftEnd-inorderLeftStart;
        int postOrderRightStart = postOrderLetfEnd;
        //同样根据中序子数组长度计算
        int postOrderRightEnd = postOrderRightStart+inOrderRightEnd-inOrderRightStart;

        // 第六步：递归处理左区间和右区间
        root.left = getRoot(inorder,inorderLeftStart,inorderLeftEnd,postorder,postOrderLeftStart,postOrderLetfEnd);
        root.right = getRoot(inorder,inOrderRightStart,inOrderRightEnd,postorder,postOrderRightStart,postOrderRightEnd);
        return root;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
