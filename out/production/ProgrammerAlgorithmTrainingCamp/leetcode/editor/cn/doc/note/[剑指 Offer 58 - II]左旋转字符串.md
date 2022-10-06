## [剑指offer 56-Ⅱ.左旋字符串](https://leetcode.cn/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/)

### 字符串拼接
#### 思路
- 创建一个新字符串以n为分界线先拼接后半段再拼接前半段

```java
class Solution {
    public String reverseLeftWords(String s, int n) {
        //双指针队列
        char[] chars = s.toCharArray();
        int left = 0;
        int right = n;
        StringBuilder stringBuilder = new StringBuilder();
        //拼接后半段
        while (right<chars.length){
            stringBuilder.append(chars[right++]);
        }
        //拼接前半段
        while (left<n){
            stringBuilder.append(chars[left++]);
        }
        return stringBuilder.toString();
    }
}
```

### 通过反转实现

#### 思路
- 整体反转再局部反转
1. 以n为分界线反转前后子串
2. 反转整个字符串

```java
class Solution {
    public String reverseLeftWords(String s, int n) {
        char[] chars = s.toCharArray();
        //局部反转
        reverse(chars,0,n-1);
        reverse(chars,n, chars.length-1);
        //整体反转
        reverse(chars,0, chars.length-1);

        return new String(chars);

    }

    public void reverse(char[] chars,int left, int right){
       char temp ;
       while (left<right){
           temp = chars[left];
           chars[left] = chars[right];
           chars[right] = temp;
           left++;
           right--;
       }
    }
}
```


