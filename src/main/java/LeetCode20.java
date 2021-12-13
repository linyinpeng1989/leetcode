import java.util.Stack;

/**
 * @author Yinpeng.Lin
 * @see <a href="有效的括号">https://leetcode-cn.com/problems/valid-parentheses/</a>
 * @date Created in 2021/12/1 16:44
 */
public class LeetCode20 {

    /**
     * 左括号入栈，右括号出栈并匹配
     */
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        // 声明一个栈
        Stack stack = new Stack();

        // 循环遍历
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '(' || c=='[' || c=='{') {
                stack.push(c);
                continue;
            }

            if (stack.isEmpty()) {
                return false;
            }

            char topChar = (char) stack.pop();
            if ((c == ')' && topChar=='(') || (c == ']' && topChar=='[') || (c == '}' && topChar=='{')) {
                continue;
            }
            return false;
        }
        // 栈为空时，即为有效的括号，若非空则为无效括号
        return stack.isEmpty();
    }

}
