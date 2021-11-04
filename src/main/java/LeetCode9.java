/**
 * @author Yinpeng.Lin
 * @see <a href="回文数">https://leetcode-cn.com/problems/palindrome-number/</a>
 * @date Created in 2021/11/4 10:20
 */
public class LeetCode9 {

    public boolean isPalindrome(int x) {
        // 负数直接返回false
        if (x < 0) {
            return false;
        }

        // 将 int 转换为 char 数组
        char[] chars = String.valueOf(x).toCharArray();

        // 前后两个下标，遍历对比是否一致
        int head = 0;
        int tail = chars.length - 1;
        while (head <= tail) {
            if (chars[head] != chars[tail]) {
                return false;
            }
            head++;
            tail--;
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode9 leetCode = new LeetCode9();
        System.out.println(leetCode.isPalindrome(121));
        System.out.println(leetCode.isPalindrome(-121));
        System.out.println(leetCode.isPalindrome(10));
        System.out.println(leetCode.isPalindrome(-101));
    }

}
