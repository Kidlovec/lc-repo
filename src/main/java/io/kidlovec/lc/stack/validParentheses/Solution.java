package io.kidlovec.lc.stack.validParentheses;

import java.util.Stack;

/**
 * TODO description
 *
 * @author kidlovec
 * @date 2020-01-18
 */
public class Solution {
    public boolean isValid(String s) {

        Stack<Integer> stack = new Stack<>();

        int index = 0;
        final char[] chars = s.toCharArray();

        int len = s.length();

        while (index < len) {
            final char aChar = chars[index];
            if (checkLeft(aChar)) {
                stack.push((int) aChar);
            } else {

                if (stack.isEmpty()) {
                    return false;
                }

                // 非左 ，查看是否匹配右
                final int peek = stack.peek();

                if (checkLeftEqualsRight((char) peek, aChar)) {
                    // 如栈顶括号 与 当前 右括号 匹配 ，则 消除栈顶括号。
                    stack.pop();
                } else {
                    // 否则， 返回 false
                    return false;
                }
            }
            index++;
        }

        // 结束时， 若栈为空 则 括号合法，否则不合法

        return stack.isEmpty();

    }

    private boolean checkLeftEqualsRight(char peek, char aChar) {
        if (('(' == peek && aChar == peek + 1) ||
                (peek == aChar - 2)) {
            return true;
        }

        return false;
    }

    private boolean checkLeft(char aChar) {
        if ('(' == aChar ||
                '[' == aChar ||
                '{' == aChar) {

            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        String[] testData = new String[]{
                "()",
                "()[]{}",
                "(]",
                "([)]",
                "{[]}",
        };

        for (String str : testData
        ) {
            s.test(str);
        }
    }

    private void test(String str) {

        System.out.println();
        System.out.println(str + " is " + isValid(str));
        System.out.println("----------------------");
    }
}
