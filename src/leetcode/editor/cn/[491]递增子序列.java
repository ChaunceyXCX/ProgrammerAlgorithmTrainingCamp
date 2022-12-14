//给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。 
//
// 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,6,7,7]
//输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,4,3,2,1]
//输出：[[4,4]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 15 
// -100 <= nums[i] <= 100 
// 
//
// Related Topics 位运算 数组 哈希表 回溯 👍 528 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        backTracking(nums,0);
        return result;
    }

    public void backTracking(int[] nums, int startIndex){
        if (path.size() >=2){
            result.add(new ArrayList<>(path));
        }

        Map<Integer,Integer> used = new HashMap();

        for (int i = startIndex; i < nums.length; i++) {
            //层级去重
            //由于本题限制固定顺序用以下方式判断层级重复会有问题要用used数组判断
            // if (i>startIndex && nums[i] == nums[i-1]){
            //     continue;
            // }
            if (used.containsKey(nums[i])){
                continue;
            }
            //叶子级别判断大小保证递增:  path为空或则path最后一个元素小于当前元素
            if (path.isEmpty() || nums[i]>=path.get(path.size()-1)){
                used.put(nums[i],nums[i]);
                path.add(nums[i]);
                backTracking(nums,i+1);
                path.remove(path.size()-1);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
