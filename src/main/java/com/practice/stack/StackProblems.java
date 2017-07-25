package com.practice.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by jonathondegn on 7/24/17.
 */
public class StackProblems {
}

class SetOfStacks<T> {
    List<Stack<T>> stackList = new ArrayList<>();
    int max;

    SetOfStacks(int maxStackSize) {
        max = maxStackSize;
    }

    void push(T item) {
        if (stackList.size() == 0) {
            stackList.add(new Stack<>());
        }
        if (stackList.get(stackList.size() - 1).size() == max) {
            stackList.add(new Stack<>());
        }
        stackList.get(stackList.size() - 1).push(item);
    }

    T pop() {
        Stack<T> stack = stackList.get(stackList.size() - 1);
        T item = stack.pop();
        if (stack.size() == 0) {
            stackList.remove(stackList.size() - 1);
        }
        return item;
    }

    T popAt(int stackNum) {
        Stack<T> stack = stackList.get(stackNum);
        T item = stack.pop();
        if (stack.size() == 0) {
            stackList.remove(stackNum);
        }
        return item;
    }

}

class MyQueue<T> {
    Stack<T> newest = new Stack<T>();
    Stack<T> oldest = new Stack<T>();

    void enqueue(T item) {
        newest.push(item);

    }

    T dequeue() {
        shiftStacks();
        return oldest.pop();
    }

    T peek() {
        shiftStacks();
        return oldest.peek();
    }

    private void shiftStacks() {
        if (oldest.isEmpty()) {
            while (!newest.isEmpty()) {
                oldest.push(newest.pop());
            }
        }
    }

    int size() {
        return newest.size() + oldest.size();
    }
}