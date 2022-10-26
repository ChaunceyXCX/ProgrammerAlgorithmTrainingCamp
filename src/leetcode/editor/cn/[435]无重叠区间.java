//给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。返回 需要移除区间的最小数量，使剩余区间互不重
//叠 。 
//
// 
//
// 示例 1: 
//
// 
//输入: intervals = [[1,2],[2,3],[3,4],[1,3]]
//输出: 1
//解释: 移除 [1,3] 后，剩下的区间没有重叠。
// 
//
// 示例 2: 
//
// 
//输入: intervals = [ [1,2], [1,2], [1,2] ]
//输出: 2
//解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
// 
//
// 示例 3: 
//
// 
//输入: intervals = [ [1,2], [2,3] ]
//输出: 0
//解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= intervals.length <= 10⁵ 
// intervals[i].length == 2 
// -5 * 10⁴ <= starti < endi <= 5 * 10⁴ 
// 
//
// Related Topics 贪心 数组 动态规划 排序 👍 823 👎 0


import java.util.Arrays;
import java.util.Comparator;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // 按照有边界排序,交叉时取有边界最小的,这样留给后面区间的范围就大了
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int count = 0;
        int minRight = Integer.MIN_VALUE;
        for (int i = 0; i < intervals.length; i++) {
            // 如果有边界小于等于下一个的左边界说明无交集
            if (minRight<=intervals[i][0]){
                minRight = intervals[i][1];
            }else {
                count++; //有交集,且右边界大于当前最小右边界删除数加一
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
