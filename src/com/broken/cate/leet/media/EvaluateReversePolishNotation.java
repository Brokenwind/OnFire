package com.broken.cate.leet.media;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Set<String> op = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
        for (String item : tokens) {
            if (op.contains(item)) {
                if (stack.size() < 2) {
                    return -1;
                } else {
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    switch (item) {
                        case "+":
                            stack.push(num2 + num1);
                            break;
                        case "-":
                            stack.push(num2 - num1);
                            break;
                        case "*":
                            stack.push(num2 * num1);
                            break;
                        case "/":
                            stack.push(num2 / num1);
                            break;
                    }
                }
            } else {
                stack.push(Integer.valueOf(item));
            }
        }
        return stack.pop();
    }
}
