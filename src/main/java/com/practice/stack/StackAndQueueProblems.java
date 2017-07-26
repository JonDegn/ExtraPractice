package com.practice.stack;

import java.util.*;

/**
 * Created by jonathondegn on 7/24/17.
 */
public class StackAndQueueProblems {
    // Sort a stack using a temp stack
    static void sortStack(Stack<Integer> stack) {
        if (stack == null) return;
        Stack<Integer> tempStack = new Stack<>();
        while (!stack.isEmpty()) {
            int tempVal = stack.pop();
            while (!tempStack.isEmpty() && tempStack.peek() > tempVal) {
                stack.push(tempStack.pop());
            }
            tempStack.push(tempVal);
        }
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }

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


// Queue of cats and dogs. can dequeue either one.
class AnimalQueue {
    private Queue<Pet> dogQueue = new ArrayDeque<>();
    private Queue<Pet> catQueue = new ArrayDeque<>();
    private int count = 0;

    void enqueue(Pet p) {
        p.setOrder(count++);
        if (p.type == Pet.Type.Dog) {
            dogQueue.add(p);
        } else {
            catQueue.add(p);
        }
    }

    Pet dequeueDog() {
        return dogQueue.poll();
    }

    Pet dequeueCat() {
        return catQueue.poll();
    }

    Pet dequeueAny() {
        if (dogQueue.isEmpty()) {
            return catQueue.poll();
        } else if (catQueue.isEmpty()) {
            return dogQueue.poll();
        }

        return dogQueue.peek().getOrder() < catQueue.peek().getOrder() ?
                dogQueue.remove() : catQueue.remove();
    }
}

class Pet {
    Type type;
    String name = "";
    int order;

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    Pet(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    enum Type {
        Dog,
        Cat
    }
}
