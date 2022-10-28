//当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。 
//
// 给定一个整数 n ，返回 小于或等于 n 的最大数字，且数字呈 单调递增 。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = 10
//输出: 9
// 
//
// 示例 2: 
//
// 
//输入: n = 1234
//输出: 1234
// 
//
// 示例 3: 
//
// 
//输入: n = 332
//输出: 299
// 
//
// 
//
// 提示: 
//
// 
// 0 <= n <= 10⁹ 
// 
//
// Related Topics 贪心 数学 👍 307 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int monotoneIncreasingDigits(int n) {
        String str = String.valueOf(n);
        char[] chars = str.toCharArray();
        int flag = str.length();
        for (int i = chars.length-1; i >0 ; i--) {  //注意这里是i大于0 ，因为i==0不用判断前一位
            if (chars[i]<chars[i-1]){
                flag = i; //从第i位开始赋值9
                chars[i-1]--; //前一位减一后一位补9 是最接近的递增数字
            }
        }

        for (int i = flag; i < chars.length; i++) {
            chars[i] = '9';
        }

        return Integer.valueOf(new String(chars));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
