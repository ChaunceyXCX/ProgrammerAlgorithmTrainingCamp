//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// Related Topics 数组 回溯 👍 2262 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        //需要将used数组传入下下一层递归，保证下一层可选元素不能在used数组中
        int[] used = new int[nums.length];
        backTracking(nums, used);
        return result;
    }

    public void backTracking(int[] nums, int[] used){
        // 当所有元素排列进path中记录并返回
        if (path.size() == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 保证下一层可选元素不能在used数组中
            if (used[i] == 1){
                continue;
            }
            path.add(nums[i]);
            used[i] = 1;
            backTracking(nums,used);
            path.remove(path.size()-1);
            used[i] = 0;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
