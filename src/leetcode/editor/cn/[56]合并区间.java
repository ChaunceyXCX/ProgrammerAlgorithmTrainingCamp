//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁴ 
// 
//
// Related Topics 数组 排序 👍 1687 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {



        Arrays.sort(intervals, Comparator.comparing(a->a[0]));
        List<int[]> list = new ArrayList<>();


        int lastStart = intervals[0][0],lastEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            //重叠,合并
            if (!(intervals[i][0]>lastEnd)){

                lastEnd = Math.max(lastEnd,intervals[i][1]);
            }else {
                list.add(new int[]{lastStart,lastEnd}); //因为这里记录的是上一区间,所以在循环结束时还是要把最后一个区间记录
                lastStart = intervals[i][0];
                lastEnd = intervals[i][1];
            }

        }
        list.add(new int[]{lastStart,lastEnd});
        return list.toArray(new int[0][]);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
