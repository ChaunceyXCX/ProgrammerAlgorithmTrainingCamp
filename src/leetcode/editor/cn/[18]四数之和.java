//给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[
//b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）： 
//
// 
// 0 <= a, b, c, d < n 
// a、b、c 和 d 互不相同 
// nums[a] + nums[b] + nums[c] + nums[d] == target 
// 
//
// 你可以按 任意顺序 返回答案 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,2,2,2], target = 8
//输出：[[2,2,2,2]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics 数组 双指针 排序 👍 1387 👎 0


import java.util.ArrayList;
import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            //剪枝
            if (nums[i]>target && nums[i]>=0){
                break;
            }
            //i去重
            if (i>0 && nums[i] == nums[i-1]){
                continue;
            }
            for (int j = i+1; j < nums.length; j++) {
                //剪枝
                if (nums[i]+nums[j]>target && nums[i]+nums[j]>=0){
                    break;
                }
                //j去重
                if (j>i+1 && nums[j] == nums[j-1]){
                    continue;
                }
                int left = j+1;
                int right = nums.length-1;
                while (left<right){
                    int temp = nums[i]+nums[j]+nums[left]+nums[right];
                    if (temp == target){
                        List<Integer> tempList = new ArrayList<>();
                        tempList.add(nums[i]);
                        tempList.add(nums[j]);
                        tempList.add(nums[left]);
                        tempList.add(nums[right]);
                        list.add(tempList);

                        //去重
                        while (left<right && nums[left] == nums[left+1]) left++;
                        while (left<right && nums[right] == nums[right-1]) right--;

                        //向中间靠拢
                        left++;
                        right--;
                    }else if (temp<target){
                        left++;
                    }else  {
                        right--;
                    }
                }
            }
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
