package com.broken.cate.leet.easy;

public class MinStack {
    int[] data;
    int[] min;
    // 栈顶值的位置
    int top;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        data = new int[255];
        min = new int[255];
        top = -1;
    }

    public void push(int x) {
        data[++top] = x;
        if (top > 0)
            min[top] = (x < min[top - 1]) ? x : min[top - 1];
        else
            min[top] = x;
    }

    public void pop() {
        top--;
    }

    public int top() {
        return data[top];
    }

    public int getMin() {
        return min[top];
    }

    public static void main(String[] args) {

    }
}
