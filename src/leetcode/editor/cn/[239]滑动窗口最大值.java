//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回 滑动窗口中的最大值 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 1 <= k <= nums.length 
// 
//
// Related Topics 队列 数组 滑动窗口 单调队列 堆（优先队列） 👍 1902 👎 0


import java.util.Deque;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //    TODO
    class MyQueue {
        Deque<Integer> deque = new LinkedList<>();

        //这个函数是用来处理窗口移动时队尾元素弹出的，因为这里定义了单调队列保证队尾就是最大元素所以要弹出的队尾元素可能已经不在队列中了，比如1，3，-1 中的 1
        public void pop(int value) {
            if (!deque.isEmpty() && value == deque.peekLast()) {
                deque.pollLast();
            }
        }

        public void push(int value) {
            //首先要保证队列中没有比新加入元素小的元素
            while (!deque.isEmpty() && value > deque.getFirst()) {
                deque.pollFirst();
            }
            deque.push(value);
        }

        public int getMax() {
            return deque.peekLast();
        }


    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        MyQueue myQueue = new MyQueue();
        // 首先创建第一个窗口
        for (int i = 0; i < k; i++) {
            myQueue.push(nums[i]);
        }
        int index = 0;
        res[index] = myQueue.getMax();
        for (int i = k; i < nums.length; i++) {
            myQueue.pop(nums[i-k]);
            myQueue.push(nums[i]);
            index = index+1;
            res[index] =myQueue.getMax();
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
