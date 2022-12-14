//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
//
// Related Topics 哈希表 字符串 回溯 👍 2146 👎 0


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> result = new ArrayList<>();
    StringBuilder path = new StringBuilder();
    static Map<String,String> KEY_MAP = new HashMap<>();
    static {
        KEY_MAP.put("0","");
        KEY_MAP.put("1","");
        KEY_MAP.put("2","abc");
        KEY_MAP.put("3","def");
        KEY_MAP.put("4","ghi");
        KEY_MAP.put("5","jkl");
        KEY_MAP.put("6","mno");
        KEY_MAP.put("7","pqrs");
        KEY_MAP.put("8","tuv");
        KEY_MAP.put("9","wxyz");
    }
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.isEmpty()) {
            return result;
        }
        backTracking(digits,0);
        return result;
    }

    public void backTracking(String digits, int startIndex){
        // 字串的长度满足digits长度
        if (path.length() == digits.length()){
            result.add(path.toString());
            return;
        }
        // System.out.println(digits.charAt(0));
        String digit = String.valueOf(digits.charAt(startIndex));
        // System.out.println(digit);
        //每层迭代一个数字对应的字符串
        String letters = KEY_MAP.get(digit);
        for (int i = 0; i < letters.length(); i++) {
            path.append(letters.charAt(i));
            // System.out.println(path.toString());
            // 下层迭代下一个数字
            backTracking(digits,startIndex+1);
            // System.out.println(path.toString());
            path.deleteCharAt(path.length()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
