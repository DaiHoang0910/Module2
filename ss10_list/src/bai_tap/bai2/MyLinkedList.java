package bai_tap.bai2;

import org.w3c.dom.Node;

public class MyLinkedList<E> {
    private Node head;
    private int numNode;

    public class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return data;
        }
    }

    public MyLinkedList() {
        head = null;
        numNode = 0;
    }

    public void add(int index, E element) {
        if (index < 0 || index > numNode) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + numNode);
        }
        Node newNode = new Node(element);

        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            for (int i = 1; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        numNode++;
    }

    public void remove(int index) {
        if (index < 0 || index > numNode) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + numNode);
        }
        if (index == 0) {
            head = head.next;
        } else {
            Node current = head;
            for (int i = 1; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        numNode--;
    }

    public int size() {
        return numNode;
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

}
