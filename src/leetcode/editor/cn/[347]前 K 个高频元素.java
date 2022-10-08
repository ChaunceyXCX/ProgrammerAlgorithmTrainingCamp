//给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 
//输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// k 的取值范围是 [1, 数组中不相同的元素的个数] 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的 
// 
//
// 
//
// 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。 
//
// Related Topics 数组 哈希表 分治 桶排序 计数 快速选择 排序 堆（优先队列） 👍 1341 👎 0


import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //计算元素次数
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        //求前k个元素
        PriorityQueue<int[]> queue = new PriorityQueue<>((q1,q2)->q1[1]-q2[1]);
        for (Map.Entry entry:
             map.entrySet()) {
            queue.add(new int[]{(int) entry.getKey(), (int) entry.getValue()});
            if (queue.size()>k){
                queue.poll();
            }
        }

        //队列转数组，因为这里用了小顶堆如果按照从大到小返回的话数组元素从后向前组装
        int[] res = new int[k];
        for (int i = k-1; i >= 0 ; i--) {
            res[i] = queue.poll()[0];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
