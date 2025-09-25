package org.example.task2;

import java.util.Arrays;
import java.util.EmptyStackException;

public class IntStack {

    private int[] elements;
    private int count;
    private static final int DEFAULT_CAPACITY = 10;

    public IntStack() {
        this.elements = new int[DEFAULT_CAPACITY];
        this.count = 0;
    }

    public void push(int value) {
        if (this.count == this.elements.length) {
            grow();
        }
        this.elements[this.count] = value;
        this.count++;
    }

    public int pop() {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        this.count--;
        return this.elements[this.count];
    }

    public int peek() {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        return this.elements[this.count - 1];
    }

    public int size() {
        return this.count;
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public void clear() {
        this.count = 0;
        Arrays.fill(this.elements, 0);
    }

    private void grow() {
        int newCapacity = this.elements.length * 2;
        this.elements = Arrays.copyOf(this.elements, newCapacity);
    }
}
