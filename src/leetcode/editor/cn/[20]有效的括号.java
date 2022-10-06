//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 每个右括号都有一个对应的相同类型的左括号。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
//
// Related Topics 栈 字符串 👍 3536 👎 0


import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        if (s.length()%2!=0) return false; //长度为奇数不可能有效
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                stack.push(')');
            }else if (s.charAt(i) == '{') {
                stack.push('}');
            } else if (s.charAt(i) == '['){
                stack.push(']');
            } else if (stack.isEmpty() || s.charAt(i) != stack.peek()){
                return false; //1.栈为空证明有多余的右括号;2.当前栈顶右括号不等于当前第i位右括号
            } else {
                stack.pop(); //当前字符与栈顶元素相等弹栈判断下个右括号
            }
        }
        return stack.isEmpty(); //如果不为空证明字符串遍历完毕仍有没有匹配的左括号
    }
}
//leetcode submit region end(Prohibit modification and deletion)
