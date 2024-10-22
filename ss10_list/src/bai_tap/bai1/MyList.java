package bai_tap.bai1;

import java.util.Arrays;
import java.util.Objects;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        elements = new Object[capacity];
    }

    public void add(int index, E element) {
        ensureCapacity(size + 1);
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
//        if (index >= 0 && index < elements.length) {
//            size++;
//            ensureCapa();
//            for (int i = size - 2; i >= index; i--) {
//                elements[i] = elements[i + 1];
//            }
//            elements[index] = element;
//        }
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        E removeElement = (E) elements[index];

        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
        return removeElement;
//        for (int i = index; i < size; i++) {
//            elements[i] = elements[i + 1];
//        }
//        size -= 1;
//        return (E) elements[index];
    }

    public int size() {
        return size;
    }

    @Override
    public MyList<E> clone() {
        MyList<E> clone = new MyList<>(size);
        for (int i = 0; i < size; i++) {
            clone.add((E) elements[i]);
        }
        return clone;
    }

    public boolean contains(E o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(o, elements[i])) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(E o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(elements[i])) {
                return i;
            }
        }
        return -1;
    }

    public boolean add(E e) {
        ensureCapacity(size + 1);
        elements[size] = e;
        size++;
        return true;
    }

    public Object[] getData() {
        return this.elements;
    }

    public void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            int newCapacity = Math.max(elements.length * 2, minCapacity);
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    public E get(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + size);
        }
        return (E) elements[i];
    }
}
